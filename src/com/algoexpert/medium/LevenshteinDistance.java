package com.algoexpert.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class LevenshteinDistance {

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "yabd";
        System.out.println(levenshteinDistance(str1, str2));
    }

    public static int levenshteinDistance(String str1, String str2) {
        int[][] edits = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < str1.length() + 1; i++) {
            for (int j = 0; j < str2.length() + 1; j++) {
                edits[i][j] = j;
            }
            edits[i][0] = i;
        }

        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    // буквы совпадают, вставок не нужно, берем количество вставок с
                    // предыдущего шага
                    edits[i][j] = edits[i-1][j-1];
                } else {
                    int minEdits = Math.min(edits[i][j-1], edits[i-1][j-1]);
                    minEdits = Math.min(minEdits, edits[i-1][j]);
                    edits[i][j] = minEdits + 1;
                }
            }
        }
        return edits[str1.length()][str2.length()];
    }
}
