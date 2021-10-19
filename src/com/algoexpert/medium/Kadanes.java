package com.algoexpert.medium;

public class Kadanes {

    public static void main(String[] args) {

    }

    public static int kadanesAlgorithm(int[] array) {
        if (array.length == 0) return 0;
        int maxSum = array[0];
        int maxEnding = array[0];

        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            maxEnding = Math.max(maxEnding + value, value);
            maxSum = Math.max(maxSum, maxEnding);
        }

        return maxSum;
    }
}
