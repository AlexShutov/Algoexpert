package com.algoexpert.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public class MinMaxStack {

    public static void main(String[] args) {

    }

    static class MinMaxStackDataStructure {

        private Deque<Integer> mValueDeque = new ArrayDeque<>();
        private Deque<Pair> mMinMaxDeque = new ArrayDeque<>();

        public int peek() {
            // Write your code here.
            return mValueDeque.peekLast();
        }

        public int pop() {
            mMinMaxDeque.removeLast();
            return mValueDeque.removeLast();
        }

        public void push(Integer number) {
            Pair currMinMax = new Pair(number, number);
            if (!mMinMaxDeque.isEmpty()) {
                // сравним текущие минимальные и максимальные значения со значениями из стека
                // минмакс для предыдущих значенияй
                Pair minMaxHistory = mMinMaxDeque.peekLast();
                currMinMax.mMin = Math.min(currMinMax.mMin, minMaxHistory.mMin);
                currMinMax.mMax = Math.max(currMinMax.mMax, minMaxHistory.mMax);
            }
            mMinMaxDeque.addLast(currMinMax);
            mValueDeque.addLast(number);
        }

        public int getMin() {
            return mMinMaxDeque.peekLast().mMin;
        }

        public int getMax() {
            return mMinMaxDeque.peekLast().mMax;
        }


        private static class Pair {
            public Pair(Integer min, Integer max) {
                mMin = min;
                mMax = max;
            }

            Integer mMin;
            Integer mMax;
        }
    }
}
