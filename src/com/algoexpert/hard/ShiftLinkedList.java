package com.algoexpert.hard;

public class ShiftLinkedList {
    public static void main(String[] args) {
        int[] queries =  {3, 2, 1, 2, 6, 0, 5, 3};
        int[] queries2 = {0, 5, 3, 3, 2, 1, 2, 6};
        ShiftLinkedList a = new ShiftLinkedList();
    }

    public static LinkedList shiftLinkedList(LinkedList head, int k) {
        int listLength = 1;
        LinkedList tail = head;
        while (tail.next != null) {
            listLength++;
            tail = tail.next;
        }
        int headOffset = Math.abs(k) % listLength;
        if (headOffset == 0) {
            return head;
        }

        int newTailPosition =  (k > 0) ? listLength - headOffset : headOffset ;
        LinkedList newTail = head;
        for (int i = 1; i < newTailPosition; i++) {
            newTail = newTail.next;
        }
        LinkedList newHead = newTail.next;
        newTail.next = null;
        tail.next = head;

        return newHead;
    }

    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }
    }
}
