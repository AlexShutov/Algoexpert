package com.leetcode.medium.java;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] numbers = {-1,0,1,2,-1,-4};
        ThreeSum a = new ThreeSum();
        System.out.println("For numbers " + Arrays.toString(numbers) + " distinct triplets such as a + b + c = 0 is:");
        System.out.println(a.threeSum(numbers));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> triplets = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int firstNumber = nums[i];
            int left = i + 1;
            int right = nums.length -1;
            while (left < right) {
                int currSum = firstNumber + nums[left] + nums[right];
                if (currSum < 0) {
                    // current sum is less than 0, increase it by moving left pointer to the right
                    left++;
                } else if (currSum > 0) {
                    // current sum is too big, decrease it
                    right--;
                } else {
                    // currSum == 0, triplet found
                    triplets.add(Arrays.asList(firstNumber, nums[left], nums[right]));
                    left++;
                    right--;
                }
            }
        }

        return new ArrayList<>(triplets);
    }
}
