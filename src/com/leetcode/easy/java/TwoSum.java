package com.leetcode.easy.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        TwoSum alg = new TwoSum();
        System.out.println("Numbers: " + Arrays.toString(numbers) +" target: " + target);
        System.out.println("Two sum: " + Arrays.toString(alg.twoSum(numbers, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> diffMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            int diff = target - number;
            if (diffMap.containsKey(number)) {
                int[] result = new int[2];
                result[1] = diffMap.get(number);
                result[0] = i;
                return result;
            } else {
                diffMap.put(diff, i);
            }
        }

        return null;
    }
}
