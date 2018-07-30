package com.github.bangnab.astrocalc;


import java.time.ZonedDateTime;

public class JulianDay {

    private static final int YEAR = 0;
    private static final int MONTH = 1;
    private static final int DAY = 2;
    private static final int HOURS = 3;
    private static final int MINUTES = 4;
    private static final int SECONDS = 5;
    private static final int MILLIS = 6;

    /**
     * Converts a ZonedDateTime to a
     * Julian Day Number.
     */
    public static double toJD(ZonedDateTime time) {
        int year = time.getYear();
        int month = time.getMonthValue();
        int day = time.getDayOfMonth();
        int hours = time.getHour();
        int minutes = time.getMinute();
        int seconds = time.getSecond();
        int millis = time.getNano() / 1_000_000;


        double decimalDay = day + (hours / 24.0) +
                (minutes / 1440.0) +
                (seconds / 86400.0) +
                (millis / 86400000.0);

        if (month == 1 || month == 2) {
            year--;
            month = month + 12;
        }

        double A = 0;
        double B = 0;
        if (time.isAfter(ZonedDateTime.parse("1582-10-15T00:00:00Z"))) {
            A = Math.floor(year / 100);
            B = 2 - A + Math.floor(A / 4);
        }

        return (Math.floor(365.25 * (year + 4716.0)) +
                Math.floor(30.6001 * (month + 1)) +
                decimalDay + B - 1524.5);
    }

    /**
     * Converts an Julian Day Number (double) to a ZonedDateTime. Works for all positive JDN
     *
     * @param jd Julian Day Number
     * @return ZonedDateTIme
     */
    public static ZonedDateTime toTimestamp(double jd) {

        int a, b, c, d, e;

        int z = (int) Math.floor(jd);
        double f = jd - z;

        if (z >= 2299161) {
            int alpha = (int) Math.floor((z - 1867216.25) / 36524.25);
            a = z + 1 + alpha - (int) Math.floor(alpha / 4);
        } else {
            a = z;
        }

        b = a + 1524;
        c = (int) Math.floor((b - 122.1) / 365.25);
        d = (int) Math.floor(365.25 * c);
        e = (int) Math.floor((b - d) / 30.6001);

        int day = b - d - (int) Math.floor(30.6001 * e);
        int month = (e < 14)
                ? (e - 1)
                : (e - 13);
        int year = (month > 2)
                ? (c - 4716)
                : (c - 4715);

        f = f * 24.0;
        int hour = (int) Math.floor(f);
        f = (f - hour) * 60.0;
        int minute = (int) Math.floor(f);
        f = (f - minute) * 60.0;
        int second = (int) Math.floor(f);
        f = (f - second) * 1000.0;
        int millis = (int) Math.floor(f);

        return ZonedDateTime.parse(String.format("%04d-%02d-%02dT%02d:%02d:%02d.%03dZ", year, month, day, hour, minute, second, millis));
    }
}
