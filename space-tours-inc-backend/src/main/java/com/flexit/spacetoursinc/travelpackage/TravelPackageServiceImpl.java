package com.flexit.spacetoursinc.travelpackage;

import com.flexit.spacetoursinc.booking.BookingService;
import com.flexit.spacetoursinc.booking.BookingVo;
import com.flexit.spacetoursinc.common.exception.StiBusinessException;
import com.flexit.spacetoursinc.hotelroom.HotelRoomVo;
import com.flexit.spacetoursinc.spaceship.SpaceshipVo;
import com.flexit.spacetoursinc.common.base.BaseServiceImpl;
import com.flexit.spacetoursinc.common.utils.DateUtils;
import com.flexit.spacetoursinc.propellants.PropellantService;
import com.flexit.spacetoursinc.propellants.PropellantVo;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class TravelPackageServiceImpl extends BaseServiceImpl<TravelPackage, TravelPackageVo> implements TravelPackageService {

    private static final Integer DAYS_TO_LOOKUP_OFFSET = 50;

    private final BookingService bookingService;
    private final PropellantService propellantService;

    public TravelPackageServiceImpl(TravelPackageRepository repository,
                                    TravelPackageConverter converter,
                                    BookingService bookingService,
                                    PropellantService propellantService) {
        super(repository, converter);
        this.bookingService = bookingService;
        this.propellantService = propellantService;
    }

    @Nonnull
    @Override
    public List<TravelPackageAvailabilityVo> getAvailabilitiesByDate(LocalDate checkAvailabilityDate) {
        List<TravelPackageVo> travelPackages = findAll();
        List<BookingVo> bookings = bookingService.findByDepartureDateBetween(
                Date.valueOf(checkAvailabilityDate.minusDays(DAYS_TO_LOOKUP_OFFSET)),
                Date.valueOf(checkAvailabilityDate.plusDays(DAYS_TO_LOOKUP_OFFSET))
        );
        List<PropellantVo> propellants = propellantService.findAllDetails();

        return travelPackages.stream()
                .map(travelPackage -> new TravelPackageAvailabilityVo(
                        travelPackage,
                        travelPackage.getTotalTicketsCount(),
                        countAvailableTicketsForTravelPackage(checkAvailabilityDate, travelPackage, bookings),
                        getPrice(travelPackage, propellants)))
                .collect(Collectors.toList());
    }

    private Integer countAvailableTicketsForTravelPackage(LocalDate checkAvailabilityDate, TravelPackageVo travelPackage,
                                                          List<BookingVo> bookings) {
        List<BookingVo> travelPackageBookings = bookings.stream()
                .filter(b -> b.getTravelPackage().getId().equals(travelPackage.getId()))
                .collect(Collectors.toList());

        return travelPackage.hasHotelRoomNights()
                ? countAvailableTicketsWithRooms(checkAvailabilityDate, travelPackage, travelPackageBookings)
                : countAvailableTicketsWithoutRooms(checkAvailabilityDate, travelPackage, travelPackageBookings);
    }

    private int countAvailableTicketsWithoutRooms(LocalDate checkAvailabilityDate, TravelPackageVo travelPackage,
                                                  List<BookingVo> travelPackageBookings) {
        // If travel package has no hotel room nights included, available tickets are only based on number of spaceship seats minus passengers
        return travelPackage.getSpaceship().getSeats() - travelPackageBookings.stream()
                .filter(b -> b.getDepartureDate().toLocalDate().isEqual(checkAvailabilityDate))
                .mapToInt(BookingVo::getPassengers)
                .reduce(0, Integer::sum);
    }

    private Integer countAvailableTicketsWithRooms(LocalDate checkAvailabilityDate, TravelPackageVo travelPackage,
                                                   List<BookingVo> travelPackageBookings) {
        int availableLunarCyclerRooms = countAvailableRooms(checkAvailabilityDate, 0,
                travelPackage.getLunarCyclerHotelRoomNights(), Optional.ofNullable(travelPackage.getLunarCyclerHotelRoom()),
                travelPackageBookings);
        int availableOrbRooms = countAvailableRooms(checkAvailabilityDate, travelPackage.getLunarCyclerHotelRoomNights(),
                travelPackage.getOrbHotelRoomNights(), Optional.ofNullable(travelPackage.getOrbHotelRoom()),
                travelPackageBookings);

        return travelPackage.hasLunarCyclerHotelRoomNights() && !travelPackage.hasOrbHotelRoomNights()
                ? availableLunarCyclerRooms
                : Math.min(availableLunarCyclerRooms, availableOrbRooms);
    }

    private int countAvailableRooms(LocalDate checkAvailabilityDate, Integer arrvialDateOffsetDays, Integer roomStayDays,
                                    Optional<HotelRoomVo> hotelRoom, List<BookingVo> bookings) {
        return hotelRoom
                .map(room -> {
                    Integer reservedCount = (int) bookings.stream()
                            .filter(booking -> {
                                LocalDate roomArrivalDate = booking.getDepartureDate().toLocalDate().plusDays(arrvialDateOffsetDays);
                                LocalDate roomLeaveDate = roomArrivalDate.plusDays(roomStayDays);
                                return DateUtils.isWithinRange(checkAvailabilityDate, roomArrivalDate, roomLeaveDate);
                            }).count();
                    return room.getNumberTotal() - reservedCount;
                })
                .orElse(0);
    }

    private Double getPrice(TravelPackageVo travelPackage, List<PropellantVo> propellants) {
        Double oneDirectionFlightCost = getFlightCostPerSeat(travelPackage.getSpaceship(), propellants);
        int lunarCyclerHotelCost = Optional.ofNullable(travelPackage.getLunarCyclerHotelRoom())
                .map(hotelRoom -> travelPackage.getLunarCyclerHotelRoomNights() * hotelRoom.getPricePerDayEuro())
                .orElse(0);
        int orbHotelCost = Optional.ofNullable(travelPackage.getOrbHotelRoom())
                .map(hotelRoom -> travelPackage.getOrbHotelRoomNights() * hotelRoom.getPricePerDayEuro())
                .orElse(0);

        return oneDirectionFlightCost * 2 + lunarCyclerHotelCost + orbHotelCost;
    }

    private Double getFlightCostPerSeat(SpaceshipVo spaceship, List<PropellantVo> propellants) {
        PropellantVo propellant = propellants.stream()
                .filter(p -> p.getId().equals(spaceship.getPropellantId()))
                .findFirst()
                .orElseThrow(() -> new StiBusinessException("Propellant for spaceship not found"));

        double propellantKg = spaceship.getCarriedWeight() / propellant.getThrust().getCarryCapacity().getAmount();
        double propellantCost = propellantKg * propellant.getPrice();
        double totalFlightCost = propellantCost * spaceship.getPropellantMarkup();

        return totalFlightCost / spaceship.getSeats();
    }
}
