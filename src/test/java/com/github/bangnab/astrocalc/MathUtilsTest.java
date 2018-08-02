package com.github.bangnab.astrocalc;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class MathUtilsTest {


    @ParameterizedTest
    @CsvSource({
            "1.0, 10, 1.0",
            "11.0, 10, 1.0",
            "-9.0, 10, 1.0",
            "-109.0, 10, 1.0",
            "100001.0, 10, 1.0"
    })
    void returnPositiveModForDoubles(double input, int modulo, double output) {
        assertThat(MathUtils.positiveMod(input, modulo), equalTo(output));
    }


    @ParameterizedTest
    @CsvSource({
            "1, 10, 1",
            "11, 10, 1",
            "-9, 10, 1",
            "-109, 10, 1",
            "1000000000001, 10, 1"
    })
    void returnPositiveModForLongs(long input, int modulo, int output) {
        assertThat(MathUtils.positiveMod(input, modulo), equalTo(output));
    }
}