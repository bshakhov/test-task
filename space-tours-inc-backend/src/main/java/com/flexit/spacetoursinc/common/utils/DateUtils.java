package com.flexit.spacetoursinc.common.utils;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;

@UtilityClass
public class DateUtils {

    public Boolean isWithinRange(LocalDate testDate, LocalDate rangeFrom, LocalDate rangeTo) {
        return !(testDate.isBefore(rangeFrom) || testDate.isAfter(rangeTo));
    }

}
