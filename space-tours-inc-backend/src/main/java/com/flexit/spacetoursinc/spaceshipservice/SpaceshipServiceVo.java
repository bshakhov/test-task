package com.flexit.spacetoursinc.spaceshipservice;

import com.flexit.spacetoursinc.common.base.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class SpaceshipServiceVo extends BaseVo {

    @NotBlank
    @NotNull
    private String name;

    @NotNull
    private UUID orbId;

}
