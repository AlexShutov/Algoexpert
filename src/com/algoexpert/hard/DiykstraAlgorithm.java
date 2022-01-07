package com.algoexpert.hard;

public class DiykstraAlgorithm {
    public static void main(String[] args) {

        DiykstraAlgorithm da = new DiykstraAlgorithm();
        int start = 0;
        int[][][] edges = new int[][][]{
          new int[][]{{1, 7}},
                new int[][]{{2, 6}, {3, 20}, {4, 3}},
                new int[][]{{3, 14}},
                new int[][]{{4, 2}},
                new int[][]{{}},
                new int[][]{{}}
        };
        int[] distances = da.dijkstrasAlgorithm(start, edges);
        if (distances.length == 0) {
            System.out.println("Distances list is empty");
        } else {
            for (int i = 0; i < distances.length; i++) {
                System.out.print(String.valueOf(distances[i]) + " ");
            }
        }
    }

    public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
        // Write your code here.
        return new int[] {};
    }
}
