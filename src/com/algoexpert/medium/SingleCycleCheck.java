package com.algoexpert.medium;

public class SingleCycleCheck {

    public static void main(String[] args) {
        
    }

    public static boolean hasSingleCycle(int[] array) {
        int jumpCount = 0;
        int pos = 0;
        int[] visitCounts = new int[array.length];

        while (jumpCount < array.length) {
            int newPos = getJumpPosition(pos, array[pos], array.length);
            visitCounts[newPos]++;
            pos = newPos;
            jumpCount++;
        }
        for (int count : visitCounts) {
            if (count != 1) return false;
        }
        return true;
    }

    private static int getJumpPosition(int position, int jumpSize, int len) {
        int nextIndex = (position + jumpSize) % len;
        return nextIndex >=0 ? nextIndex : nextIndex + len;
    }

    // Было решение с массивом, теперь - просто счетчик
    public static boolean hasSingleCycleSpace1(int[] array) {
        int jumpCount = 0;
        int currPos = 0;
        while (jumpCount < array.length) {
            // Проверяем, если мы прошли по малому циклу - вернулись в начало,
            // не обойдя все элементы
            if (jumpCount > 0 && currPos == 0) return false;
            currPos = makeJump(currPos, array);
            jumpCount++;
        }
        return currPos == 0;
    }

    private static int makeJump(int position, int[] array) {
        int jumpPos = (position + array[position]) % array.length;
        if (jumpPos >= 0) return jumpPos;
        else return jumpPos + array.length;
    }
}
