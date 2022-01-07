package com.leetcode.easy.java;

public class PlusOne {
    public static void main(String[] args) {
//        int[] number = {1, 2, 3, 4, 9};
        int[] number = {9};
//        int[] number = {1, 2, 3, 4, 0};
//        int[] number = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        PlusOne plusOne = new PlusOne();
        int[] incremented = plusOne.plusOne(number);
        for (int i: incremented) {
            System.out.println(i + " ");
        }
    }

    public int[] plusOne(int[] digits) {

        int idx = digits.length -1;
        boolean carry = false;
        digits[digits.length -1]++;
        do {
            int digit = digits[idx];
            if (carry) {
                digit++;
            }
            if (digit > 9) {
                digit = 0;
                carry = true;
            } else {
                carry = false;
            }
            digits[idx] = digit;
            idx--;
        } while (idx >= 0 && carry);

        if (carry) {
            // we have one carry left
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (idx = 0; idx < digits.length; idx++) {
                result[result.length - idx -1] = digits[digits.length - idx -1];
            }
            return result;
        }

        return digits;
    }
}
