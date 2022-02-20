package com.algoexpert.hard;

import java.util.Arrays;

public class QuickSelect {
    public static void main(String[] args) {
        int[] values = {8, 5, 2, 9, 7, 6, 3};
        int k = 3;
        System.out.println("Values: " + Arrays.toString(values));
        System.out.println(String.valueOf(k) + " largest value: " + QuickSelect.quickselect(values, k));
    }

    public static int quickselect(int[] array, int k) {
        int targetIndex = k -1;
        return quickSelectRecursive(0, array.length -1, array, targetIndex);
    }

    private static int quickSelectRecursive(int startIndex, int endIndex, int[] array, int k) {
        if (startIndex >= endIndex) {
            return array[startIndex];
        }
        int pivot = startIndex;
        int left = pivot + 1;
        int right = endIndex;
        while (left <= right) {
            if (array[left] > array[pivot] && array[right] < array[pivot]) {
                swap(left, right, array);
            }
            if (array[left] <= array[pivot]) {
                left++;
            }
            if (array[right] >= array[pivot]) {
                right--;
            }
        }
        swap(right, pivot, array);
        if (right == k) {
            return array[right];
        }
        if (k < right) {
            return quickSelectRecursive(startIndex, right -1, array, k);
        } else {
            return quickSelectRecursive(right + 1, endIndex, array, k);
        }
    }

    static void swap(int left, int right, int[] array) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
