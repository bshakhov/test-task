package com.flexit.spacetoursinc.travelpackage;

import com.flexit.spacetoursinc.hotelroom.HotelRoom;
import com.flexit.spacetoursinc.spaceship.Spaceship;
import com.flexit.spacetoursinc.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.UUID;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class TravelPackage extends BaseEntity {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    private UUID departureOrbId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "spaceship_id")
    private Spaceship spaceship;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lunar_cycler_hotel_room_id")
    private HotelRoom lunarCyclerHotelRoom;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "orb_hotel_room_id")
    private HotelRoom orbHotelRoom;

    @PositiveOrZero
    private Integer lunarCyclerHotelRoomNights;

    @PositiveOrZero
    private Integer orbHotelRoomNights;

}
