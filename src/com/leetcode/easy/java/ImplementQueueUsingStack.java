package com.leetcode.easy.java;

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementQueueUsingStack {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        int[] numbers = new int[] {1, 2, 3, 4, 5, 6};
        ImplementQueueUsingStack a = new ImplementQueueUsingStack();
        for (int i : numbers) {
            queue.push(i);
        }

        while (!queue.empty()) {
            System.out.print(queue.peek() + " ");
            queue.pop();
        }
    }

    static class MyQueue {
        private Deque<Integer> mFillStack;
        private Deque<Integer> mEmptyStack;


        public MyQueue() {
            mFillStack = new ArrayDeque<>();
            mEmptyStack = new ArrayDeque<>();
        }

        public void push(int x) {
            mFillStack.push(x);
        }

        public int pop() {
            if (mEmptyStack.isEmpty()) {
                fillEmptyStack();
            }
            return mEmptyStack.removeLast();
        }

        public int peek() {
            if (mEmptyStack.isEmpty()) {
                fillEmptyStack();
            }
            return mEmptyStack.peekLast();
        }

        public boolean empty() {
            return mEmptyStack.isEmpty() && mFillStack.isEmpty();
        }

        private void fillEmptyStack() {
            while(!mFillStack.isEmpty()) {
                mEmptyStack.push(mFillStack.removeLast());
            }
        }
    }
}
