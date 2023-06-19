package com.flexit.spacetoursinc.booking;

import com.flexit.spacetoursinc.common.base.BaseVo;
import com.flexit.spacetoursinc.travelpackage.TravelPackageVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.sql.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class BookingVo extends BaseVo {

    @NotNull
    private Date departureDate;

    @NotNull
    @Positive
    private Integer passengers;

    @NotNull
    private TravelPackageVo travelPackage;

}
