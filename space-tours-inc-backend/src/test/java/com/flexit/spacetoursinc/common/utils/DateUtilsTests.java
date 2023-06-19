package com.flexit.spacetoursinc.common.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("DateUtils")
public class DateUtilsTests {

    @Nested
    @DisplayName("#isWithinRange")
    class IsWithinRange {

        private final LocalDate rangeFrom = LocalDate.parse("2020-01-05");
        private final LocalDate rangeTo = LocalDate.parse("2020-01-07");

        @Test
        @DisplayName("should return TRUE if within date range")
        public void returnTrueIfWithinRange() {
            Boolean result = DateUtils.isWithinRange(LocalDate.parse("2020-01-06"), rangeFrom, rangeTo);
            assertTrue(result);
        }

        @Test
        @DisplayName("should return TRUE if at range from date")
        public void returnTrueIfAtRangeFrom() {
            Boolean result = DateUtils.isWithinRange(LocalDate.parse("2020-01-05"), rangeFrom, rangeTo);
            assertTrue(result);
        }

        @Test
        @DisplayName("should return TRUE if at range to date")
        public void returnTrueIfAtRangeTo() {
            Boolean result = DateUtils.isWithinRange(LocalDate.parse("2020-01-07"), rangeFrom, rangeTo);
            assertTrue(result);
        }

        @Test
        @DisplayName("should return FALSE if before range from date")
        public void returnFalseIfBeforeRangeFrom() {
            Boolean result = DateUtils.isWithinRange(LocalDate.parse("2020-01-04"), rangeFrom, rangeTo);
            assertFalse(result);
        }

        @Test
        @DisplayName("should return FALSE if after range to date")
        public void returnFalseIfAfterRangeTo() {
            Boolean result = DateUtils.isWithinRange(LocalDate.parse("2020-01-08"), rangeFrom, rangeTo);
            assertFalse(result);
        }

    }

}
