package com.algoexpert.hard;

public class MergeLinkedLists {
    public static void main(String[] args) {
        MergeLinkedLists a = new MergeLinkedLists();
    }

    // This is an input class. Do not edit.
    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        LinkedList p1 = headOne;
        LinkedList p2 = headTwo;
        LinkedList p1Prev = null;
        while (p1 != null && p2 != null) {
            if (p1.value < p2.value) {
                p1Prev = p1;
                p1 = p1.next;
            } else {
                if (p1Prev != null) {
                    p1Prev.next = p2;
                }
                p1Prev = p2;
                p2 = p2.next;
                p1Prev.next = p1;
            }
        }
        if (p2 == null) {
            // do nothing, we inserted all values from p2
        }
        if (p1 == null) {
            // we used all values from p1, add list 2 to the end of list 1
            p1Prev.next = p2;
        }
        LinkedList result = headOne.value < headTwo.value ? headOne : headTwo;
        return result;
    }
}
