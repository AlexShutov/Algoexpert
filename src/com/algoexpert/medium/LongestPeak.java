package com.algoexpert.medium;

import java.util.ArrayList;
import java.util.List;

public class LongestPeak {

    /**
     * {"arrayOne": [-1, 5, 10, 20, 3], "arrayTwo": [26, 134, 135, 15, 17]}
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[]{5, 4, 3, 2, 1, 2, 1};
            System.out.println("Longest Peak: " + longestPeak(array));
    }

    public static int longestPeak(int[] array) {
        int longestPeak = 0;
        int i = 1;
        while (i < array.length -1) {
            boolean isPeak = array[i] > array[i -1] && array[i] > array[i + 1];
            if (!isPeak) {
                i++;
                continue;
            }
            int left = i -2;
            while (left >= 0 && array[left] < array[left + 1]) left--;
            int right = i + 2;
            while (right < array.length && array[right] < array[right ]) right++;
            int currPeakLen = right - left - 1;
            if (currPeakLen > longestPeak) {
                longestPeak = currPeakLen;
            }
            // следкющий пик может начаться только после текущего, нет смысла
            // проверять каждое значение, они будут убывать
            i = right;
        }
        return longestPeak;
    }
}
