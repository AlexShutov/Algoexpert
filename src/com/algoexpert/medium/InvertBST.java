package com.algoexpert.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class InvertBST {

    public static void main(String[] args) {

    }

    public static void invertBinaryTreeR(BinaryTree tree) {
        if (tree.left == null && tree.right == null) {
            return;
        }

        if (tree.left != null) {
            invertBinaryTreeR(tree.left);
        }
        if (tree.right != null) {
            invertBinaryTreeR(tree.right);
        }

        BinaryTree tmp = tree.left;
        tree.left = tree.right;
        tree.right = tmp;
    }

    public static void invertBinaryTreeIterative(BinaryTree tree) {
        Deque<BinaryTree> callStack = new ArrayDeque<>();
        callStack.addFirst(tree);
        while (!callStack.isEmpty()) {
            BinaryTree currNode = callStack.pollLast();
            swapChildren(currNode);
            if (currNode.left != null) {
                callStack.addLast(currNode.left);
            }
            if (currNode.right != null) {
                callStack.addLast(currNode.right);
            }
        }
    }

    private static void swapChildren(BinaryTree tree) {
        BinaryTree tmp = tree.left;
        tree.left = tree.right;
        tree.right = tmp;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
