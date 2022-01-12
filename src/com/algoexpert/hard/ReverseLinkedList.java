package com.algoexpert.hard;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ReverseLinkedList a = new ReverseLinkedList();
    }

    public static LinkedList reverseLinkedList(LinkedList head) {
        LinkedList previous = null;
        LinkedList current = head;
        LinkedList next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
