package com.leetcode.medium.java;

public class LongestPalindromeSubstrinng {
    public static void main(String[] args) {
        String str = "babad";
        LongestPalindromeSubstrinng a = new LongestPalindromeSubstrinng();
        System.out.println("Longest palindrome substring of " + str + " is: " + a.longestPalindrome(str));
    }

    public String longestPalindrome(String s) {
        int[] longest = new int[]{0, 1};
        for (int i = 1; i < s.length(); i++) {
            int[] oddIndicies = getPalindromeSubstring(i-1, i + 1, s);
            int[] evenIndicies = getPalindromeSubstring(i-1, i, s);
            int[] currLongest = getLength(oddIndicies) > getLength(evenIndicies) ? oddIndicies : evenIndicies;
            if (getLength(currLongest) > getLength(longest)) {
                longest = currLongest;
            }
        }
        return s.substring(longest[0], longest[1]);
    }

    private int[] getPalindromeSubstring(int leftIndex, int rightIndex, String str) {
        while (leftIndex >= 0 && rightIndex < str.length()) {
            if (str.charAt(leftIndex) != str.charAt(rightIndex)) {
                break;
            }
            leftIndex--;
            rightIndex++;
        }
        // left index will be decreased by on on last loop cycle (== -1)
        return new int[]{leftIndex + 1, rightIndex};
    }

    private int getLength(int[] indicies) {
        return indicies[1] - indicies[0];
    }
}
