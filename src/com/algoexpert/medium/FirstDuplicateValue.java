package com.algoexpert.medium;

import java.util.Set;
import java.util.TreeSet;

public class FirstDuplicateValue {
    public static void main(String[] args) {
        System.out.println("test test");
    }

    public int firstDuplicateValue(int[] array) {
        Set<Integer> visited = new TreeSet<>();
        for (int value: array) {
            if (visited.contains(value)) {
                return value;
            } else {
                visited.add(value);
            }
        }
        return -1;
    }

    public int firstDuplicateValue2(int[] array) {
        int[] indicies = new int[array.length];
        for (int value: array) {
            int index = value -1;
            if (indicies[index] != 0) {
                return value;
            } else {
                indicies[index] = 1;
            }
        }
        return -1;
    }
}
