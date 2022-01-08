package com.leetcode.easy.java;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] words = new String[]{"flower","flow","flight"};
        LongestCommonPrefix a = new LongestCommonPrefix();
        System.out.println("Longest common prefix for " + Arrays.toString(words) + " is: " +
                a.longestCommonPrefix(words));
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        int currLetterPosition = 0;
        int minStrLength = Integer.MAX_VALUE;
        for (String s: strs) {
            minStrLength = Math.min(minStrLength, s.length());
        }
        while(currLetterPosition < minStrLength) {
            char currLetter = strs[0].charAt(currLetterPosition);
            for (int i = 1; i < strs.length; i++) {
                String str = strs[i];
                if (str.charAt(currLetterPosition) != currLetter) {
                    return prefix.toString();
                }
            }
            prefix.append(strs[0].charAt(currLetterPosition));
            currLetterPosition++;
        }
        return prefix.toString();
    }
}
