package com.algoexpert.easy.java;

import java.util.Arrays;

public class MinimumWaitingTime {
    public static void main(String[] args) {
        int[] queries = {3, 2, 1, 2, 6};
        MinimumWaitingTime a = new MinimumWaitingTime();
        System.out.println(a.minimumWaitingTime(queries));
    }

    public int minimumWaitingTime(int[] queries) {
        // sort quieries time ascending
        Arrays.sort(queries);
        int waitingTime = 0;
        for (int i = 0; i < queries.length; i++) {
            waitingTime += queries[i] * (queries.length - (i + 1));
        }
        return waitingTime;
    }
}
