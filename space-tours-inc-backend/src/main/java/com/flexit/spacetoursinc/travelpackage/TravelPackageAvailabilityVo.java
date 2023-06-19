package com.flexit.spacetoursinc.travelpackage;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TravelPackageAvailabilityVo {

    private TravelPackageVo travelPackage;

    private Integer totalTicketsCount;

    private Integer availableTicketsCount;

    private Double price;

}
