package com.algoexpert.medium;

import java.util.ArrayList;
import java.util.List;

public class Powerset {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> powerset(List<Integer> array) {
        List<List<Integer>> powerset =  new ArrayList<>();
        // можем сразу добавить пустое множество
        powerset.add(new ArrayList<>());
        for (int currNumber: array) {
            List<List<Integer>> newSets = deepCopy(powerset);
            for (List<Integer> s : newSets) {
                s.add(currNumber);
            }
            powerset.addAll(newSets);
        }

        return powerset;
    }

    private static List<List<Integer>> deepCopy(List<List<Integer>> values) {
        List<List<Integer>> copy = new ArrayList<>();
        for (List<Integer> subset : values) {
            copy.add((new ArrayList<>(subset)));
        }
        return copy;
    }

    public static List<List<Integer>> powersetRecursive(List<Integer> array) {
        return powerset(array.size()-1, array);
    }

    private static List<List<Integer>> powerset(int currIndex, List<Integer> array) {
        if (currIndex < 0) {
            List<List<Integer>> empty = new ArrayList<>();
            empty.add(new ArrayList<>());
            return empty;
        }
        int number = array.get(currIndex);
        List<List<Integer>> subsets = powerset(currIndex - 1, array);
        List<List<Integer>> newSubsets = new ArrayList<>();
        for (int i= 0; i < subsets.size(); i++) {
            List<Integer> subsetCopy = new ArrayList<>(subsets.get(i));
            subsetCopy.add(number);
            newSubsets.add(subsetCopy);
        }
        subsets.addAll(newSubsets);
        return subsets;
    }
}
