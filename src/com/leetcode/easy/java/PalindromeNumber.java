package com.leetcode.easy.java;

public class PalindromeNumber {
    public static void main(String[] args) {
        int number = 121;
        PalindromeNumber a = new PalindromeNumber();
        System.out.println("Is number " + number + " a palindrome? " + a.isPalindrome(number));
    }

    public boolean isPalindrome(int x) {
        String number = String.valueOf(x);
        int left = 0;
        int right = number.length() -1;
        while (left < right) {
            if (number.charAt(left) != number.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
