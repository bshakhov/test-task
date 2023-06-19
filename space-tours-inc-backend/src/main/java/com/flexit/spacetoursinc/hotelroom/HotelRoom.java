package com.flexit.spacetoursinc.hotelroom;

import com.flexit.spacetoursinc.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.UUID;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class HotelRoom extends BaseEntity {

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
