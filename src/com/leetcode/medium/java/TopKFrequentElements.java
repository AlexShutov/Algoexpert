package com.leetcode.medium.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static void main(String[] args) {
        TopKFrequentElements alg = new TopKFrequentElements();
        int[] numbers = new int[]{1,1,1,2,2,3};
        int k = 2;
        System.out.println("Top " + k + " frequent elements of array " +
                Arrays.toString(numbers) + " is: " + Arrays.toString(alg.topKFrequent(numbers, k)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int i: nums) {
            frequencies.put(i, frequencies.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((number1, number2) -> {
             return frequencies.get(number2) - frequencies.get(number1);
        });
        minHeap.addAll(frequencies.keySet());
        int[] result = new  int[k];
        for (int i = 0;  i < k; i++) {
            result[i] = minHeap.remove();
        }

        return result;
    }
}
