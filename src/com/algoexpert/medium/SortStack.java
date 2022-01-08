package com.algoexpert.medium;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortStack {

    public static void main(String[] args) {
        ArrayList<Integer> values = new ArrayList<>(Arrays.asList(-5, 2, -2, 4, 3, 1));
        SortStack alg = new SortStack();
        List<Integer> sorted = alg.sortStack(values);
        System.out.println(sorted);
    }

    public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
        if (stack.isEmpty()) {
            return stack;
        }
        int topValue = stack.remove(stack.size() -1);
        sortStack(stack);
        insertValueInSortedStack(topValue, stack);

        return stack;
    }

    private void insertValueInSortedStack(int value, ArrayList<Integer> sortedStack) {
        if (sortedStack.isEmpty() || sortedStack.get(sortedStack.size()-1) <= value) {
            sortedStack.add(value);
            return;
        }

        int topValue = sortedStack.remove(sortedStack.size() -1);
        insertValueInSortedStack(value, sortedStack);
        sortedStack.add(topValue);
    }
}
