package com.flexit.spacetoursinc.travelpackage;

import com.flexit.spacetoursinc.booking.BookingService;
import com.flexit.spacetoursinc.booking.BookingVo;
import com.flexit.spacetoursinc.hotelroom.HotelRoomVo;
import com.flexit.spacetoursinc.propellants.PropellantCarryCapacityVo;
import com.flexit.spacetoursinc.propellants.PropellantService;
import com.flexit.spacetoursinc.propellants.PropellantThrustVo;
import com.flexit.spacetoursinc.propellants.PropellantVo;
import com.flexit.spacetoursinc.spaceship.SpaceshipVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Date;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@DisplayName("TravelPackageService")
class TravelPackageServiceTests {

    private static final Date TEST_DATE = Date.valueOf("2021-01-01");

    @InjectMocks
    TravelPackageServiceImpl service;

    @Mock
    @SuppressWarnings("unused")
    TravelPackageRepository travelPackageRepositoryMock;

    @Mock
    @SuppressWarnings("unused")
    TravelPackageConverter travelPackageConverterMock;

    @Mock
    BookingService bookingServiceMock;

    @Mock
    PropellantService propellantServiceMock;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);

        SpaceshipVo testSpaceship = SpaceshipVo.builder()
                .seats(200)
                .weightKg(549045)
                .maxCapacityKg(22800)
                .propellantId(1)
                .propellantMarkup(3)
                .build();

        HotelRoomVo testLunarCyclerHotelRoom = HotelRoomVo.builder()
                .lunarCyclerId(UUID.randomUUID())
                .numberTotal(150)
                .pricePerDayEuro(300)
                .build();

        HotelRoomVo testOrbHotelRoom = HotelRoomVo.builder()
                .orbId(UUID.randomUUID())
                .pricePerDayEuro(500)
                .numberTotal(80)
                .build();

        TravelPackageVo travelPackageWithoutHotelStay = TravelPackageVo.builder()
                .id(UUID.randomUUID())
                .name("Travel package without hotel stay")
                .spaceship(testSpaceship)
                .lunarCyclerHotelRoomNights(0)
                .orbHotelRoomNights(0)
                .build();

        TravelPackageVo travelPackageWithLunarCyclerStay = TravelPackageVo.builder()
                .id(UUID.randomUUID())
                .name("Travel package with lunar cycler hotel stay")
                .spaceship(testSpaceship)
                .lunarCyclerHotelRoom(testLunarCyclerHotelRoom)
                .lunarCyclerHotelRoomNights(13)
                .orbHotelRoomNights(0)
                .build();

        TravelPackageVo travelPackageWithLunarCyclerAndOrbStay = TravelPackageVo.builder()
                .id(UUID.randomUUID())
                .name("Travel package with lunar cycler and orb hotel stay")
                .spaceship(testSpaceship)
                .lunarCyclerHotelRoom(testLunarCyclerHotelRoom)
                .orbHotelRoom(testOrbHotelRoom)
                .lunarCyclerHotelRoomNights(13)
                .orbHotelRoomNights(6)
                .build();

        when(service.findAll()).thenReturn(Arrays.asList(
                travelPackageWithoutHotelStay,
                travelPackageWithLunarCyclerStay,
                travelPackageWithLunarCyclerAndOrbStay
        ));

        when(propellantServiceMock.findAllDetails()).thenReturn(Collections.singletonList(
                PropellantVo.builder()
                        .id(1)
                        .price(.202)
                        .thrust(PropellantThrustVo.builder()
                                .carryCapacity(PropellantCarryCapacityVo.builder()
                                        .amount(1d)
                                        .build())
                                .build())
                        .build()
        ));

        when(bookingServiceMock.findByDepartureDateBetween(any(Date.class), any(Date.class))).thenReturn(Arrays.asList(
                BookingVo.builder()
                        .departureDate(TEST_DATE)
                        .passengers(2)
                        .travelPackage(travelPackageWithoutHotelStay)
                        .build(),
                BookingVo.builder()
                        .departureDate(TEST_DATE)
                        .passengers(2)
                        .travelPackage(travelPackageWithLunarCyclerStay)
                        .build()
        ));
    }

    @Nested
    @DisplayName("#getAvailabilitiesByDate")
    class GetAvailabilitiesByDate {

        @Test
        @DisplayName("should get availabilities by date")
        public void shouldGetAvailabilitiesByDate() {
            List<TravelPackageAvailabilityVo> result = service.getAvailabilitiesByDate(TEST_DATE.toLocalDate());

            assertEquals(3, result.size());

            // Travel package without hotel stay
            TravelPackageAvailabilityVo withoutHotelStay = result.get(0);
            assertEquals(3465.3807, withoutHotelStay.getPrice());
            assertEquals(198, withoutHotelStay.getAvailableTicketsCount());

            // Travel package with lunar cycler hotel stay
            TravelPackageAvailabilityVo withLunarCyclerHotelStay = result.get(1);
            assertEquals(7365.3807, withLunarCyclerHotelStay.getPrice());
            assertEquals(149, withLunarCyclerHotelStay.getAvailableTicketsCount());

            // Travel package with lunar cycler and orb hotel stay
            TravelPackageAvailabilityVo withLunarCyclerAndOrbHotelStay = result.get(2);
            assertEquals(10365.3807, withLunarCyclerAndOrbHotelStay.getPrice());
            assertEquals(80, withLunarCyclerAndOrbHotelStay.getAvailableTicketsCount());
        }
    }

}
