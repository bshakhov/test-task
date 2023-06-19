package com.flexit.spacetoursinc.hotelroom;

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
public class HotelRoomVo extends BaseVo {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @PositiveOrZero
    private Integer numberTotal;

    @NotNull
    @PositiveOrZero
    private Integer pricePerDayEuro;

    private UUID lunarCyclerId;

    private UUID orbId;

}
