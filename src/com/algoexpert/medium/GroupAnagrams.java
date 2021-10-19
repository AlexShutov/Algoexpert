package com.algoexpert.medium;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {

    }

    public static List<List<String>> groupAnagrams(List<String> words) {
        Map<String, List<String>> groupsMapping = new HashMap<>();
        for (String word: words) {
            char[] wordArray = word.toCharArray();
            Arrays.sort(wordArray);
            String wordSorted = String.valueOf(wordArray);
            if (!groupsMapping.containsKey(wordSorted)) {
                // добавляем новое слово в мапу
                List<String> group = new ArrayList<>();
                group.add(word);
                groupsMapping.put(wordSorted, group);
            } else {
                // добавляем слово в имеющуюся группу
                groupsMapping.get(wordSorted).add(word);
            }
        }

        return new ArrayList<>(groupsMapping.values());
    }
}
