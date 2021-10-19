package com.algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SpiralTraverse {

    /**
     * {"arrayOne": [-1, 5, 10, 20, 3], "arrayTwo": [26, 134, 135, 15, 17]}
     * @param args
     */
    public static void main(String[] args) {
         int[][] spiral = new int[][]{{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}};
         System.out.println(spiralTraverse(spiral));
    }

    public static List<Integer> spiralTraverse(int[][] array) {
        List<Integer> result = new ArrayList<>();

        int startCol = 0;
        int startRow = 0;
        int endCol = array[0].length-1;
        int endRow = array.length-1;

        while (startRow < endRow && startCol < endCol) {
            // lt -> rt
            for (int i = startCol; i <= endCol; i++) result.add(array[startRow][i]);
            // rt -> rb
            for (int j = startRow + 1; j <= endRow; j++) result.add(array[j][endCol]);
            // rb -> lb
            for (int i = endCol - 1; i >= startCol; i--) result.add(array[endRow][i]);
            // lb -> lt
            for (int j = endRow - 1; j > startRow; j--) result.add(array[j][startCol]);

            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        return result;
    }
}
