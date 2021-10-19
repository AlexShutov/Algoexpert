package com.algoexpert.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestPalindromeSubstring {

    public static void main(String[] args) {

    }

    public static String longestPalindromicSubstring(String str) {
        // начинаем, считая, что самая длинная подстрока с индексами 0, 1
        int[] longest = new int[]{0, 1};
        for (int i = 1; i < str.length(); i++) {
            // посмотрим подстроку, сосотоящую из нечетных индексов (в центре есть символ)
            int[] oddIndicies = getPalindromeSubstring(i - 1, i + 1, str);
            // посмотрим на строку, состоянщую из четны индексов (два символа рядом)
            int[] evenIndicies = getPalindromeSubstring(i -1, i, str);
            // сравним результаты поиска палиндромной подстроки и выберем наибольшую
            int[] currLongest = getLength(oddIndicies) > getLength(evenIndicies) ? oddIndicies : evenIndicies;
            // если нужно, обновим результат с самой длинной подстрокой
            if (getLength(longest) < getLength(currLongest)) {
                longest = currLongest;
            }
        }

        return str.substring(longest[0], longest[1]);
    }

    private static int getLength(int[] indicies) {
        return indicies[1] - indicies[0];
    }

    private static int[] getPalindromeSubstring(int leftIndex, int rightIndex, String str) {
        while (leftIndex >=0 && rightIndex < str.length()) {
            if (str.charAt(leftIndex) != str.charAt(rightIndex)) {
                break;
            }
            leftIndex--;
            rightIndex++;
        }
        return new int[]{leftIndex + 1,  rightIndex};
    }

    public static String longestPalindromicSubstringSet(String str) {
        // пройдемся по всем подстрокам строки и проверим, палиндромны ли они
        String longest = "";
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                String substring = str.substring(i, j + 1);
                if (isPalindrome(substring) && substring.length() > longest.length()) {
                    longest = substring;
                }
            }
        }
        return longest;
    }

    private static boolean isPalindrome(String str) {
        int l = 0;
        int r = str.length() -1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
