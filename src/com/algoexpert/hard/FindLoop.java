package com.algoexpert.hard;

public class FindLoop {
    public static void main(String[] args) {
        int[] queries = {3, 2, 1, 2, 6};
        FindLoop a = new FindLoop();
    }

    public static LinkedList findLoop(LinkedList head) {
        LinkedList first = head;
        LinkedList second = head;
        do {
            first = first.next;
            second = second.next.next;
        } while (first != second);
        first = head;
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return first;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
