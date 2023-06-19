package com.flexit.spacetoursinc.spaceship;

import com.flexit.spacetoursinc.spaceship.spaceshipbooster.SpaceshipBooster;
import com.flexit.spacetoursinc.common.base.BaseVo;
import com.flexit.spacetoursinc.spaceshipservice.SpaceshipService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class SpaceshipVo extends BaseVo {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @PositiveOrZero
    private Integer seats;

    @NotNull
    private SpaceshipBooster booster;

    @NotNull
    private SpaceshipService service;

    @NotNull
    @Positive
    private Integer weightKg;

    @NotNull
    @Positive
    private Integer maxCapacityKg;

    @NotNull
    private Integer propellantId;

    @NotNull
    @Positive
    private Integer propellantMarkup;

    public Integer getCarriedWeight() {
        return weightKg + maxCapacityKg;
    }

}
