package com.leetcode.easy.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] queries = {3, 2, 1, 2, 6};
        ContainsDuplicate a = new ContainsDuplicate();

    }

    public boolean containsDuplicateOne(int[] nums) {
        Set<Integer> values = new HashSet<>();
        for (int number: nums) {
            if (values.contains(number)) {
                return true;
            } else {
                values.add(number);
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> values = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            if (values.containsKey(number)) {
                int j = values.get(number);
                if (Math.abs(j - i) <= k) {
                    return true;
                }
            }
            values.put(number, i);
        }
        return false;
    }
}
