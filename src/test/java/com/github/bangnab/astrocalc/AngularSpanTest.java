package com.github.bangnab.astrocalc;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.equalTo;

class AngularSpanTest {

    @Test
    void fromZeroDegrees() {
        AngularSpan zero = AngularSpan.fromDegrees(0.0);
        assertThat(zero.getDegrees(), equalTo(0));
        assertThat(zero.getMinutes(), equalTo(0));
        assertThat(zero.getSeconds(), equalTo(0.0));
    }

    @Test
    void fromIntegerDegrees() {
        AngularSpan angle = AngularSpan.fromDegrees(15.0);
        assertThat(angle.getDegrees(), equalTo(15));
        assertThat(angle.getMinutes(), equalTo(0));
        assertThat(angle.getSeconds(), equalTo(0.0));
    }

    @Test
    void fromDegreesOutsideRange() {
        AngularSpan angle = AngularSpan.fromDegrees(376.5);
        assertThat(angle.getDegrees(), equalTo(16));
        assertThat(angle.getMinutes(), equalTo(30));
        assertThat(angle.getSeconds(), equalTo(0.0));
    }

    @Test
    void fromNegativeDegrees() {
        AngularSpan angle = AngularSpan.fromDegrees(-16.5);
        assertThat(angle.getDegrees(), equalTo(343));
        assertThat(angle.getMinutes(), equalTo(30));
        assertThat(angle.getSeconds(), equalTo(0.0));
    }


    @Test
    void fromNegativeDegreesOutsideRange() {
        AngularSpan angle = AngularSpan.fromDegrees(-736.5);
        assertThat(angle.getDegrees(), equalTo(343));
        assertThat(angle.getMinutes(), equalTo(30));
        assertThat(angle.getSeconds(), equalTo(0.0));
    }

    @Test
    void fromDecimalDegrees() {
        AngularSpan angle = AngularSpan.fromDegrees(15.1234);
        assertThat(angle.getDegrees(), equalTo(15));
        assertThat(angle.getMinutes(), equalTo(7));
        assertThat(angle.getSeconds(), closeTo(24.2400, 0.0001));
    }

}