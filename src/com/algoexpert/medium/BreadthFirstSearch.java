package com.algoexpert.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BreadthFirstSearch {

    public static void main(String[] args) {
        
    }

    // Do not edit the class below except
    // for the breadthFirstSearch method.
    // Feel free to add new properties
    // and methods to the class.
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            Deque<Node> jobQueue = new ArrayDeque<>();
            jobQueue.addLast(this);
            while (!jobQueue.isEmpty()) {
                Node job = jobQueue.removeFirst();
                array.add(job.name);
                for (Node child : job.children) {
                    jobQueue.addLast(child);
                }
            }

            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
