package com.algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeightBST {

    public static void main(String[] args) {
        int[] values = new int[]{1, 2, 5, 7, 10, 13, 14, 15, 22};
        List<Integer> list = new ArrayList<>();
        for (int n : values) list.add(n);

        BST bst = minHeightBst(list);
    }


    public static BST minHeightBst(List<Integer> array) {
        return constructMinHeightBst(null, array, 0, array.size() -1);
    }

    private static BST constructMinHeightBst(BST tree, List<Integer> array, int startIdx, int endIdx) {

        if (startIdx > endIdx) return null;
        int middleIdx = (endIdx + startIdx) / 2;
        if (tree == null) {
            tree = new BST(array.get(middleIdx));
        } else {
            tree.insert(array.get(middleIdx));
        }
        constructMinHeightBst(tree, array, startIdx, middleIdx -1 );
        constructMinHeightBst(tree, array, middleIdx + 1, endIdx);
        return tree;
    }

    private static BST constructMinHeightBst2(BST tree, List<Integer> array, int startIdx, int endIdx) {

        if (startIdx > endIdx) return null;
        int middleIdx = (endIdx + startIdx) / 2;
        BST newBstNode = new BST(array.get(middleIdx));
        if (tree == null) {
            tree = newBstNode;
        } else {
            if (array.get(middleIdx) < tree.value) {
                tree.left = newBstNode;
                tree = tree.left;
            } else {
                tree.right = newBstNode;
                tree = tree.right;
            }
        }
        constructMinHeightBst2(tree, array, startIdx, middleIdx -1);
        constructMinHeightBst2(tree, array, middleIdx +1, endIdx);
        return tree;
    }

    private static BST constructMinHeightBst3(BST tree, List<Integer> array, int startIdx, int endIdx) {

        if (startIdx > endIdx) return null;
        int middleIdx = (endIdx + startIdx) / 2;
        tree = new BST(array.get(middleIdx));
        tree.left = constructMinHeightBst3(tree, array, startIdx, middleIdx -1);
        tree.right = constructMinHeightBst3(tree, array, middleIdx +1, endIdx);

        return tree;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }

}
