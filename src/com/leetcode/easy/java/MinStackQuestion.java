package com.leetcode.easy.java;

import kotlin.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStackQuestion {
    public static void main(String[] args) {
        int[] queries = {3, 2, 1, 2, 6};
        MinStack minStack = new MinStack();
        minStack.push(10);
        minStack.push(6);
        minStack.push(5);
        while (!minStack.isEmpty()) {
            System.out.print(minStack.getMin() + " ");
            minStack.pop();
        }
        System.out.println();
    }

    static class MinStack {
        Deque<Pair<Integer, Integer>> mDelegateStack;

        public MinStack() {
            mDelegateStack = new ArrayDeque<>();
        }

        public void push(int val) {
            int minValue = val;
            if (!isEmpty()) {
                // compare current value with the last value in stack
                minValue = Math.min(minValue, mDelegateStack.peekLast().getSecond());
            }
            mDelegateStack.offerLast(new Pair<>(val, minValue));
        }

        public void pop() {
            mDelegateStack.removeLast();
        }

        public int top() {
            return mDelegateStack.peekLast().getFirst();
        }

        public int getMin() {
            return mDelegateStack.peekLast().getSecond();
        }

        public boolean isEmpty() {
            return mDelegateStack.isEmpty();
        }
    }
}
