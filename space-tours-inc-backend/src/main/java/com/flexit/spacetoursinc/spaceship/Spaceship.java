package com.flexit.spacetoursinc.spaceship;

import com.flexit.spacetoursinc.spaceship.spaceshipbooster.SpaceshipBooster;
import com.flexit.spacetoursinc.common.base.BaseEntity;
import com.flexit.spacetoursinc.spaceshipservice.SpaceshipService;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Spaceship extends BaseEntity {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @PositiveOrZero
    private Integer seats;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "booster_id")
    private SpaceshipBooster booster;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "service_id")
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

}
