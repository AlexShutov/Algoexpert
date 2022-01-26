package com.algoexpert.hard;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] values = {8, 5, 2, 9, 5, 6, 3};
        QuickSort a = new QuickSort();
        int[] sorted = a.quickSort(values);
        System.out.println("Values: " + Arrays.toString(values));
        System.out.println("Sorted values: " + Arrays.toString(sorted));
    }

    public static int[] quickSort(int[] array) {
        quickSortRecursive(0, array.length -1, array);

        return array;
    }

    static void quickSortRecursive(int startIndex, int endIndex, int[] array) {
        if (startIndex >= endIndex) {
            return;
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
        swap(pivot, right, array);

//        quickSortRecursive(startIndex, right -1, array);
//        quickSortRecursive(right + 1, endIndex, array);

        // call quickSortRecursive on smaller subarray first
        boolean isLeftSubArraySmaller = right -1 - startIndex < endIndex - (right + 1);
        if (isLeftSubArraySmaller) {
            // apply on left subarray first
            quickSortRecursive(startIndex, right -1, array);
            quickSortRecursive(right + 1, endIndex, array);
        } else {
            // apply on right subarray first
            quickSortRecursive(right + 1, endIndex, array);
            quickSortRecursive(startIndex, right -1, array);
        }
    }

    static void swap(int left, int right, int[] array) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
