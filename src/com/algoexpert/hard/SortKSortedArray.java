package com.algoexpert.hard;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortKSortedArray {
    public static void main(String[] args) {
        SortKSortedArray a = new SortKSortedArray();
        int[] array = new int[] {3, 2, 1, 5, 4, 7, 6, 5};
        int k = 3;

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((first, second) -> {
            return first - second;
        });
        for (int i : array) {
            queue.add(i);
        }
        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
        System.out.println("Not sorted array: " + Arrays.toString(array));
        System.out.println("Sorted array: " + Arrays.toString(a.sortKSortedArray(array, k)));
    }

    public int[] sortKSortedArray(int[] array, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((first, second) -> {
            return first - second;
        });
        for (int i = 0; i < Math.min(array.length, k + 1); i++) {
            heap.add(array[i]);
        }
        int insertIndex = 0;
        for (int i = k + 1; i < array.length; i++) {
            int minValue = heap.remove();
            array[insertIndex] = minValue;
            insertIndex++;

            int currentValue = array[i];
            heap.add(currentValue);
        }

        while (!heap.isEmpty()) {
            array[insertIndex++] = heap.remove();
        }

        return array;
    }
}
