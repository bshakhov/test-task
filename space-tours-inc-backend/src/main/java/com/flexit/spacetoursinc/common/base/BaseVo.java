package com.flexit.spacetoursinc.common.base;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.UUID;

@Data
@NoArgsConstructor
@ParametersAreNonnullByDefault
public class BaseVo {

    private UUID id;

}
