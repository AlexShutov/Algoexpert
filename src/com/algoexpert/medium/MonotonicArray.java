package com.algoexpert.medium;

import java.util.ArrayList;
import java.util.List;

public class MonotonicArray {

    /**
     * {-1, -5, -10, -1100, -1100, -1101, -1102, -9001}
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 8, 9, 10, 11};
        System.out.println(isMonotonicSimple(array));
    }

    public static boolean isMonotonic(int[] array) {
        if (array.length == 0 || array.length == 1) return true;
        boolean isTrendingUp = isTrending(array, true);
        boolean isTrendingDown = isTrending(array, false);
        if (isTrendingUp && isTrendingDown) {
            // одинаковые значения
            return true;
        }
        return isTrendingUp ^ isTrendingDown;
    }

    public static boolean isMonotonicSimple(int[] array) {
        boolean isNonDecreasing = true;
        boolean isNonIncreasing = true;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i-1]) isNonIncreasing = false;
            if (array[i] < array[i-1]) isNonDecreasing = false;
        }
        return isNonIncreasing | isNonDecreasing;
    }

    public static boolean isMonotonicComplicated(int[] array) {
        if (array.length <= 2) return true;
         int direction = array[1] - array[0];
         for (int i = 2; i < array.length; i++) {
             if (direction == 0) {
                 direction = array[i] - array[i-1];
                 continue;
             }
             if (breaksDirection(direction, array[i -1], array[i])) {
                 return false;
             }
         }
         return true;
    }

    private static boolean breaksDirection(int direction, int previous, int current) {
        int difference = current - previous;
        if (direction > 0) return difference < 0;
        return difference > 0;
    }

    private static boolean isTrending(int[] array, boolean isUpwards) {
        for (int i = 1; i < array.length; i++) {
            boolean isCurrTrendingOk = isUpwards ? array[i] >= array[i-1] : array[i] <= array[i-1];
            if (!isCurrTrendingOk) return false;
        }
        return true;
    }
}
