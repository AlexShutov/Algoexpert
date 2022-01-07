package com.leetcode.easy.java;

import java.util.ArrayList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        ListNode head= new ListNode(numbers[0], null);
        ListNode curr = head;
        for (int i = 1; i < numbers.length; i++) {
            ListNode t = new ListNode(numbers[i], null);
            curr.next = t;
            curr = t;
        }
        ReverseLinkedList rl = new ReverseLinkedList();
        System.out.println("Source list:");
        rl.printList(head);
        System.out.println("Reversed list:");
        rl.printList(rl.reverseList(head));
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        return reverseListR(head, null);
    }

    public ListNode reverseListR(ListNode currNode, ListNode parent) {
        if (currNode.next == null) {
            currNode.next = parent;
            // new head
            return currNode;
        }
        ListNode result = reverseListR(currNode.next, currNode);
        currNode.next = parent;
        return result;
    }

    public ListNode reverseListIterative(ListNode head) {
        if (head == null) {
            return null;
        }
        ArrayList<ListNode> nodeLinks = new ArrayList<>();
        ListNode currNode = head;
        while (currNode != null) {
            nodeLinks.add(currNode);
            currNode = currNode.next;
        }
        for (int i = nodeLinks.size() -1; i >= 1; i--) {
            nodeLinks.get(i).next = nodeLinks.get(i-1);
        }
        nodeLinks.get(0).next = null;

        return nodeLinks.get(nodeLinks.size() -1);
    }

    private void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(String.valueOf(curr.val) + " ");
            curr = curr.next;
            if (curr != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
