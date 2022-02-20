package com.algoexpert.hard;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HeapSort {
    public static void main(String[] args) {
        int[] values = {8, 5, 2, 9, 5, 6, 3};
        System.out.println(Arrays.toString(heapSort(values)));
    }

    public static int[] heapSort(int[] array) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((first, second) -> {
            return second - first;
        });
        for (int i: array) {
            heap.add(i);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = heap.remove();
        }
        return array;
    }
}
