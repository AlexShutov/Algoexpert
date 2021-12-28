package com.algoexpert.easy.java;

import java.util.Arrays;

public class SortedSquaredArray {
    public static void main(String[] args) {
        int[] numbers = {-5, -4, 0, 1, 2};
        SortedSquaredArray a = new SortedSquaredArray();
        int[] sorted = a.sortedSquaredArray(numbers);
        for (int n: sorted) {
            System.out.print(n + " ");
        }
    }

    public int[] sortedSquaredArraySlowSort(int[] array) {
        int[] squares = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int n = array[i];
            squares[i] = n * n;
        }
        Arrays.sort(squares);
        return squares;
    }

    public int[] sortedSquaredArray(int[] array) {
        int[] sortedSquares = new int[array.length];
        int smallestValueIndex = 0;
        int largestValueIndex = array.length -1;
        for (int i = array.length -1; i >= 0; i--) {
            int value;
            if (Math.abs(array[smallestValueIndex]) > Math.abs(array[largestValueIndex])) {
                // smaller value is negative, but its square is larger
                // insert it
                value = array[smallestValueIndex];
                smallestValueIndex++;
            } else {
                value = array[largestValueIndex];
                largestValueIndex--;
            }
            sortedSquares[i] = value * value;
        }
        return sortedSquares;
    }

}
