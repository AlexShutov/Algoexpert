package com.algoexpert.medium;

import java.util.ArrayList;

public class FindKthLargestValueInBst {

    public static void main(String[] args) {

    }

    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public int findKthLargestValueInBstFullTraverse(BST tree, int k) {
        // Write your code here.
        ArrayList<Integer> values = new ArrayList<>();
        inOrderTraverse(values, tree);
        return values.get(values.size() - k);
    }

    public void inOrderTraverse(ArrayList<Integer> values, BST tree) {
        if (tree == null) {
            return;
        }
        inOrderTraverse(values, tree.left);
        values.add(tree.value);
        inOrderTraverse(values, tree.right);
    }

    public int findKthLargestValueInBst(BST tree, int k) {
        TraverseState state = new TraverseState(0, -1);
        reversedTraversed(tree, k, state);
        // Write your code here.
        return state.lastVisitedValue;
    }

    public void reversedTraversed(BST bst, int k, TraverseState traverseState) {
        if (bst == null || traverseState.numberOfNodesVisited >= k) {
            return;
        }
        reversedTraversed(bst.right, k, traverseState);
        // handle back recursion here
        if (traverseState.numberOfNodesVisited < k) {
            traverseState.numberOfNodesVisited++;
            traverseState.lastVisitedValue = bst.value;
            reversedTraversed(bst.left, k, traverseState);
        }
    }

    class TraverseState {
        public int numberOfNodesVisited;
        public int lastVisitedValue;

        public TraverseState(int numberOfNodesVisited, int lastVisitedValue) {
            this.numberOfNodesVisited = numberOfNodesVisited;
            this.lastVisitedValue = lastVisitedValue;
        }
    }
}
