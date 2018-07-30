package com.github.bangnab.astrocalc;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.equalTo;

class JulianDayTest {

    @Test
    void name() {
        ZonedDateTime longAgo = ZonedDateTime.parse("0333-01-27T12:00:00Z");
        assertThat(JulianDay.toJD(longAgo), closeTo(1842713.0, 0.0001));
    }

    @Test
    void negativeYears() {
        ZonedDateTime longAgo = ZonedDateTime.parse("-0584-05-28T12:00:00Z");
        assertThat(JulianDay.toJD(longAgo), closeTo(1507900.0, 0.0001));
    }

    @Test
    void backToDate() {
        double jd = 2436116.31;
        ZonedDateTime zonedDateTime = JulianDay.toTimestamp(jd);
        assertThat(zonedDateTime.getYear(), equalTo(1957));
        assertThat(zonedDateTime.format(DateTimeFormatter.ISO_DATE_TIME), equalTo("1957-10-04T07:26:24Z"));
    }
}
