package com.algoexpert.medium;


import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class CycleInGraph {

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                new int[]{1, 3},
                new int[]{2, 3, 4},
                new int[]{0},
                new int[]{},
                new int[]{2, 5},
                new int[]{}
        };
        CycleInGraph cg = new CycleInGraph();
        System.out.println("Has graph a cycle? " + cg.cycleInGraph(edges));
    }

    // First solution
    public boolean cycleInGraphNotEfficient(int[][] edges) {

        Set<Integer> nodesInCallStack = new TreeSet<>();
        for (int i = 0; i < edges.length; i++) {
            if (cycleInGraphR(i, edges, nodesInCallStack)) {
                return true;
            }
        }

        return false;
    }

    public boolean cycleInGraphR(int vertex, int[][] edges, Set<Integer> nodesInCallStack) {
        // visit current vertex
        nodesInCallStack.add(vertex);

        for (int nextVertex : edges[vertex]) {
            if (nodesInCallStack.contains(nextVertex)) {
                return true;
            }
            if (cycleInGraphR(nextVertex, edges, nodesInCallStack)) {
                return true;
            }
        }
        // we visited all verticies, no cycle found at this point
        nodesInCallStack.remove(vertex);
        return false;
    }

    // Second solution
    public boolean cycleInGraphTrackVisited(int[][] edges) {
        boolean[] visited = new boolean[edges.length];
        boolean[] inStack = new boolean[edges.length];

        for (int vertex = 0; vertex < edges.length; vertex++) {
            if (visited[vertex]) {
                continue;
            }
            if (detectCycle(vertex, edges, visited, inStack)) {
                return true;
            }
        }

        return false;
    }

    private boolean detectCycle(int vertex, int[][] edges, boolean[] visited, boolean[] inStack) {
        visited[vertex] = true;
        inStack[vertex] = true;

        int[] nextVerticies = edges[vertex];
        for (int nextVertex : nextVerticies) {
            if (!visited[nextVertex] && detectCycle(nextVertex, edges, visited, inStack)) {
                return true;
            }
            if (inStack[nextVertex]) {
                return true;
            }
        }

        inStack[vertex] = false;
        return false;
    }

    //  Third solution with colorinng graph
    public boolean cycleInGraph(int[][] edges) {
        VERTEX_COLOR[] colors = new VERTEX_COLOR[edges.length];
        Arrays.fill(colors, VERTEX_COLOR.WHITE);
        for (int vertex = 0; vertex < edges.length; vertex++) {
            if (colors[vertex] == VERTEX_COLOR.BLACK) {
                continue;
            }
            int[] neighbors = edges[vertex];
            for (int neighbor : neighbors) {
                if (detectCycleColor(neighbor, edges, colors)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean detectCycleColor(int vertex, int[][] edges, VERTEX_COLOR[] colors) {
        colors[vertex] = VERTEX_COLOR.GRAY;
        for (int nextVertex : edges[vertex]) {
            switch (colors[nextVertex]) {
                case BLACK:
                    continue;
                case WHITE: {
                    if (detectCycleColor(nextVertex, edges, colors)) {
                        return true;
                    }
                }
                break;
                case GRAY:
                    // next vertex is in call stack
                    return true;
            }
        }

        colors[vertex] = VERTEX_COLOR.BLACK;
        return false;
    }

    private enum VERTEX_COLOR {
        WHITE,
        GRAY,
        BLACK
    }
}
