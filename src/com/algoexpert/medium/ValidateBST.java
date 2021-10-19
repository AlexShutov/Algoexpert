package com.algoexpert.medium;

public class ValidateBST {

    public static boolean validateBst(BST tree) {
        return validate(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean validate(BST tree, int minValue, int maxValue) {
        if (tree.value < minValue || tree.value >= maxValue) {
            return false;
        }
        if (tree.left != null && !validate(tree.left, minValue, tree.value)) {
            return false;
        }
        if (tree.right != null && !validate(tree.right, tree.value, maxValue)) {
            return false;
        }
        return true;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
