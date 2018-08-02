package com.github.bangnab.astrocalc;

public class MathUtils {

    private MathUtils() {
    }

    public static double positiveMod(double number, int modulo) {
        return (number % modulo + modulo) % modulo;
    }


    public static int positiveMod(long number, int modulo) {
        int firstIteration = (int) (number % modulo);
        return (firstIteration + modulo) % modulo;
    }
}
