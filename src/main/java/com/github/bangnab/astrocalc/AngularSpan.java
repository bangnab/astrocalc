package com.github.bangnab.astrocalc;

public class AngularSpan {
    private final double seconds;
    private final int minutes;
    private final int degrees;

    public AngularSpan(int degrees, int minutes, double seconds) {
        this.degrees = degrees;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public double getSeconds() {
        return seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getDegrees() {
        return degrees;
    }

    public static AngularSpan fromDegrees(double degrees) {
        double degreesMod = (degrees % Angles.DEGREES_MODULO + Angles.DEGREES_MODULO) % Angles.DEGREES_MODULO;
        int degreesIntegral = (int) degreesMod;
        double degreesDecimal = degreesMod - degreesIntegral;
        double minutes = degreesDecimal * Angles.MINUTES_PER_DEGREE;
        int minutesIntegral = (int) minutes;
        double minutesDecimal = minutes - minutesIntegral;
        double seconds = minutesDecimal * Angles.SECONDS_PER_MINUTE;
        return new AngularSpan(degreesIntegral, minutesIntegral, seconds);
    }

    public double toDegrees() {
        return degrees + (minutes + seconds / Angles.SECONDS_PER_MINUTE) / Angles.MINUTES_PER_DEGREE;
    }
}
