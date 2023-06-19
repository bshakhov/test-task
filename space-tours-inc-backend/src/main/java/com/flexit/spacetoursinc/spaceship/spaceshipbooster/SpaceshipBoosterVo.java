package com.flexit.spacetoursinc.spaceship.spaceshipbooster;

import com.flexit.spacetoursinc.common.base.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
public class SpaceshipBoosterVo extends BaseVo {

    @NotBlank
    @NotNull
    private String name;

}
