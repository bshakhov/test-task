package com.flexit.spacetoursinc.propellants;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PropellantThrustVo {

    private PropellantAccelerationVo acceleration;

    private PropellantCarryCapacityVo carryCapacity;

}
