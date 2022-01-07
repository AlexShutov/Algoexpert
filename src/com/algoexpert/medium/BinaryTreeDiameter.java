package com.algoexpert.medium;

public class BinaryTreeDiameter {

    public static void main(String[] args) {

    }

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public int binaryTreeDiameter(BinaryTree tree) {
        BinaryTreeInfo info = getTreeInfo(tree);
        return info.diameter;
    }

    public BinaryTreeInfo getTreeInfo(BinaryTree tree) {
        if (tree == null) {
            return new BinaryTreeInfo(0, 0);
        }

        BinaryTreeInfo infoLeft = getTreeInfo(tree.left);
        BinaryTreeInfo infoRight = getTreeInfo(tree.right);
        // compute diameter throught current head
        int diameterThroughtHead = infoLeft.height + infoRight.height;
        int maxChildDiameter = Math.max(infoLeft.diameter, infoRight.diameter);
        // max diameter is either current path throught head or max child diameter
        int maxDiameter = Math.max(diameterThroughtHead, maxChildDiameter);
        int maxChildHeight = Math.max(infoLeft.height, infoRight.height);
        return new BinaryTreeInfo(maxChildHeight + 1, maxDiameter);
    }

    class  BinaryTreeInfo {
        public int height;
        public int diameter;

        public BinaryTreeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }
}
