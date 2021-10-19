package com.algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SmallestDifference {

    /**
     * {"arrayOne": [-1, 5, 10, 20, 3], "arrayTwo": [26, 134, 135, 15, 17]}
     * @param args
     */
    public static void main(String[] args) {
        int[] arrayOne = new int[]{-1, 5, 10, 20, 28, 3};
        int[] arrayTwo = new int[]{26, 134, 135, 15, 17};
        System.out.println("Result: " + Arrays.toString(smallestDifference(arrayOne, arrayTwo)));
    }

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        List<Integer> sortedOne = new ArrayList<>();
        List<Integer> sortedTwo = new ArrayList<>();
        for (int n : arrayOne) sortedOne.add(n);
        for (int n : arrayTwo) sortedTwo.add(n);
        Collections.sort(sortedOne);
        Collections.sort(sortedTwo);

        int indexOne = 0;
        int indexTwo = 0;
        int[] smallestPair = new int[]{};
        int smallestDiff = Integer.MAX_VALUE;

        while (indexOne < sortedOne.size() && indexTwo < sortedTwo.size()) {
            int firstNumber = sortedOne.get(indexOne);
            int secondNumber = sortedTwo.get(indexTwo);
            if (firstNumber == secondNumber) {
                return new int[]{firstNumber, secondNumber};
            }
            int currentDiff = Math.abs(firstNumber - secondNumber);
            if (firstNumber < secondNumber) {
                indexOne++;
            } else {
                indexTwo++;
            }
            if (currentDiff < smallestDiff) {
                smallestDiff = currentDiff;
                smallestPair = new int[]{firstNumber, secondNumber};
            }
        }
        return smallestPair;
    }
}
