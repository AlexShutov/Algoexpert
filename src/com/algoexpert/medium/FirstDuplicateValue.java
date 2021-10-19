package com.algoexpert.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class FirstDuplicateValue {

    public static void main(String[] args) {
    }

    public int firstDuplicateValue(int[] array) {
        int[] indicies = new int[array.length + 1];
        for (int value: array) {
            int index = value;
            if (indicies[index] != 0) {
                return value;
            } else {
                indicies[index] = 1;
            }
        }
        return -1;
    }
}
