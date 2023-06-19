package com.flexit.spacetoursinc.travelpackage;

import com.flexit.spacetoursinc.hotelroom.HotelRoomVo;
import com.flexit.spacetoursinc.spaceship.SpaceshipVo;
import com.flexit.spacetoursinc.common.base.BaseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class TravelPackageVo extends BaseVo {

    private transient UUID id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    private SpaceshipVo spaceship;

    @NotNull
    private UUID departureOrbId;

    private HotelRoomVo lunarCyclerHotelRoom;

    private HotelRoomVo orbHotelRoom;

    @PositiveOrZero
    private Integer lunarCyclerHotelRoomNights;

    @PositiveOrZero
    private Integer orbHotelRoomNights;

    public Integer getTotalTicketsCount() {
        if (lunarCyclerHotelRoom != null && orbHotelRoom != null) {
            return Math.min(lunarCyclerHotelRoom.getNumberTotal(), orbHotelRoom.getNumberTotal());
        }

        if (lunarCyclerHotelRoom != null) {
            return lunarCyclerHotelRoom.getNumberTotal();
        }

        return spaceship.getSeats();
    }

    public Integer getTotalHotelRoomNights() {
        return lunarCyclerHotelRoomNights + orbHotelRoomNights;
    }

    public Boolean hasHotelRoomNights() {
        return getTotalHotelRoomNights() > 0;
    }

    public Boolean hasLunarCyclerHotelRoomNights() {
        return lunarCyclerHotelRoomNights > 0;
    }

    public Boolean hasOrbHotelRoomNights() {
        return orbHotelRoomNights > 0;
    }

}
