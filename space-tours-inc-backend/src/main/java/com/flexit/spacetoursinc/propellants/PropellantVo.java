package com.flexit.spacetoursinc.propellants;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PropellantVo {

    private Integer id;

    private String name;

    private String baseUnit;

    private Double price;

    private PropellantThrustVo thrust;

}
