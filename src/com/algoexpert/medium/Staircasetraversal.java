package com.algoexpert.medium;


import java.util.HashMap;
import java.util.Map;

public class Staircasetraversal {

    public static void main(String[] args) {
        int height = 4;
        int maxStep = 2;
        Staircasetraversal alg = new Staircasetraversal();
        System.out.println("Number for traverse staircase of height " + height + " with max step size of " +
                maxStep + " is: \n" + alg.staircaseTraversal(height, maxStep));
    }

    // Not optimal solution
    public int staircaseTraversalSimple(int height, int maxSteps) {
        return numberOfWays(height, maxSteps);
    }

    private int numberOfWays(int height, int maxSteps) {
        if (height <= 1) {
            return 1;
        }

        int result = 0;
        for (int step = 1; step < Math.min(maxSteps, height) + 1; step++) {
            result += numberOfWays(height - step, maxSteps);
        }

        return result;
    }

    // Solution with dynamic programming
    public int staircaseTraversalArray(int height, int maxSteps) {
        // step start from 1, we need one more item
        int[] history = new int[height + 1];
        history[0] = 1;
        history[1] = 1;

        return computeNumberOfWays(height, maxSteps, history);
    }

    private int computeNumberOfWays(int currHeight, int maxSteps, int[] history) {
        if (history[currHeight] != 0) {
            return history[currHeight];
        }

        int result = 0;
        for (int step = 1; step < Math.min(currHeight, maxSteps) + 1; step++) {
            result += computeNumberOfWays(currHeight - step, maxSteps, history);
        }
        history[currHeight] = result;

        return result;
    }

    // Solution with memory in HashMap
    public int staircaseTraversal(int height, int maxSteps) {
        Map<Integer, Integer> memory = new HashMap<>();
        memory.put(0, 1);
        memory.put(1, 1);

        return computeTraversal(height, maxSteps, memory);
    }

    private int computeTraversal(int currHeight, int maxSteps, Map<Integer, Integer> memory) {
        if (memory.containsKey(currHeight)) {
            return memory.get(currHeight);
        }

        int totalCount = 0;
        int step = 1;
        while (step < Math.min(currHeight, maxSteps) + 1) {
            totalCount += computeTraversal(currHeight - step, maxSteps, memory);
            step++;
        }
        memory.put(currHeight, totalCount);
        return totalCount;
    }
}
