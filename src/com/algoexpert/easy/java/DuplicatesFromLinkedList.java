package com.algoexpert.easy.java;


import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class DuplicatesFromLinkedList {
    public static void main(String[] args) {

        DuplicatesFromLinkedList tb = new DuplicatesFromLinkedList();
        tb.removeDuplicatesFromLinkedList(null);
    }

    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        LinkedList currentNode = linkedList;
        while (currentNode != null) {
            LinkedList nextNode = currentNode.next;
            while (nextNode != null && nextNode.value == currentNode.value) {
                nextNode = nextNode.next;
            }

            currentNode.next = nextNode;
            currentNode = nextNode;
        }

        return linkedList;
    }

    public LinkedList removeDuplicatesFromLinkedListVersionWithSet(LinkedList linkedList) {
        SortedSet<Integer> values = new TreeSet<>();
        LinkedList currentNode = linkedList;
        while (currentNode != null) {
            values.add(currentNode.value);
            currentNode = currentNode.next;
        }

        Iterator<Integer> it = values.iterator();
        LinkedList list = null;
        if (it.hasNext()) {
            list = new LinkedList(it.next());
            it.remove();
        }
        currentNode = list;
        while (it.hasNext()) {
            LinkedList newNode = new LinkedList(it.next());
            it.remove();
            currentNode.next = newNode;
            currentNode = newNode;
        }

        return list;
    }

}
