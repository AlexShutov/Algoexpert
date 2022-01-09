package com.algoexpert.medium;


public class Staircasetraversal {

    public static void main(String[] args) {
        int height = 4;
        int maxStep = 2;
        Staircasetraversal alg = new Staircasetraversal();
        System.out.println("Number for traverse staircase of height " + height + " with max step size of " +
                maxStep + " is: \n" + alg.staircaseTraversal(height, maxStep));
    }

    public int staircaseTraversal(int height, int maxSteps) {
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
}
