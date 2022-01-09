package com.leetcode.easy.java;

public class ClimbingStairs {
    public static void main(String[] args) {
        ClimbingStairs a = new ClimbingStairs();
        int height = 10;
        System.out.println("How many ways to climb stair by height of " + height + " if you can take 1 or 2 steps?");
        System.out.println(a.climbStairs(height));
    }

    public int climbStairs(int n) {
        // you have + 1 way for climbinng staircase of height 0
        int[] history = new int[n + 1];
        history[0] = 1;
        history[1] = 1;
        return computeNumberOfClimbStairs(n, 2, history);
    }

    private int computeNumberOfClimbStairs(int height, int maxSteps, int[] history) {
        if(history[height] != 0) {
            return history[height];
        }
        int resultNumberOfWays = 0;
        for (int i = 1; i < Math.min(maxSteps, height) + 1; i++) {
            resultNumberOfWays += computeNumberOfClimbStairs(height - i, maxSteps, history);
        }
        history[height] = resultNumberOfWays;

        return resultNumberOfWays;
    }
}
