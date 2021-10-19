package com.algoexpert.medium;

import java.util.*;

public class YoungestCommonAncestor {

    public static void main(String[] args) {

    }

    public static AncestralTree getYoungestCommonAncestorSlow(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        AncestralTree referral = descendantOne;
        while (referral != topAncestor) {
            AncestralTree t = descendantTwo;
            while (t != topAncestor) {
                if (t.name == referral.name) {
                    return referral;
                }
                t = t.ancestor;
            }

            referral = referral.ancestor;
        }
        return topAncestor;
    }

    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        int heightOne = getNodeHeight(descendantOne, topAncestor);
        int heightTwo = getNodeHeight(descendantTwo, topAncestor);

        if (heightOne > heightTwo) {
            // первый потомок находится глубже второго в дереве
            return backtrackCommonAncestor(descendantOne, descendantTwo, heightOne - heightTwo);
        } else {
            // второй глубже или на одном уровне
            return backtrackCommonAncestor(descendantTwo, descendantOne, heightTwo - heightOne);
        }
    }

    private static AncestralTree backtrackCommonAncestor(AncestralTree lower, AncestralTree higher, int heightDiff) {
        // перемотаем более глубокого потомка, чтобы оба потомка были на одном уровне
        while (heightDiff != 0) {
            lower = lower.ancestor;
            heightDiff--;
        }
        // теперь оба потомка на одном уровне, перематываем их вверх, пока указатели не встретятся
        while (lower != higher) {
            lower = lower.ancestor;
            higher = higher.ancestor;
        }
        return lower;
    }

    private static int getNodeHeight(AncestralTree curr, AncestralTree topAncestor) {
        int height = 0;
        while (curr != topAncestor) {
            height++;
            curr = curr.ancestor;
        }

        return height;
    }



    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }
}
