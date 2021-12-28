package com.algoexpert.easy.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TandemBicycle {
    public static void main(String[] args) {
        int[] redShirts = {5, 5, 3, 9, 2};
        int[] blueShirts = {3, 6, 7, 2, 1};
        TandemBicycle tb = new TandemBicycle();
        boolean fastest = false;
        System.out.println(tb.tandemBicycle(redShirts, blueShirts, fastest));
    }

    public int tandemBicycle1(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);
        int totalSpeed = 0;
        for (int i = 0; i < redShirtSpeeds.length; i++) {
            int red = redShirtSpeeds[i];
            int blue;
            if (fastest) {
                blue = blueShirtSpeeds[blueShirtSpeeds.length -i -1];
            } else {
                blue = blueShirtSpeeds[i];
            }
            totalSpeed += Math.max(red, blue);
        }
        return totalSpeed;
    }

    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);
        if (fastest) {
            reverseList(blueShirtSpeeds);
        }
        int totalSpeed = 0;
        for (int i = 0; i < redShirtSpeeds.length; i++) {
            totalSpeed += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
        }
        return totalSpeed;
    }

    private void reverseList(int[] list) {
        int left = 0;
        int top = list.length -1;
        while (left < top) {
            int t = list[left];
            list[left] = list[top];
            list[top] = t;
            left++;
            top--;
        }
    }
}
