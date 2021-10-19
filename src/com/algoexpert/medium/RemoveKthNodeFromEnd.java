package com.algoexpert.medium;

public class RemoveKthNodeFromEnd {

    public static void main(String[] args) {

    }

    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        LinkedList guide = head;
        int i = 1;
        while (i < k + 1) {
            guide = guide.next;
            i++;
        }
        if (guide == null) {
            head.value = head.next.value;
            head.next = head.next.next;
            return;
        }

        LinkedList ptr = head;
        while (guide.next != null) {
            guide = guide.next;
            ptr = ptr.next;
        }
        ptr.next = ptr.next.next;
    }


    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
