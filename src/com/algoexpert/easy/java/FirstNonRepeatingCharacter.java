package com.algoexpert.easy.java;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String line = "abcdcaf";
        FirstNonRepeatingCharacter alg = new FirstNonRepeatingCharacter();
        System.out.println(alg.firstNonRepeatingCharacter(line));
    }

    public int firstNonRepeatingCharacter1(String string) {
        Map<Character, Integer> occurences = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char letter = string.charAt(i);
            if (!occurences.containsKey(letter)) {
                occurences.put(letter, 1);
            } else {
                occurences.put(letter, occurences.get(letter) + 1);
            }
        }
        for (int i = 0; i < string.length(); i++) {
            char letter = string.charAt(i);
            if (occurences.get(letter) == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstNonRepeatingCharacter(String string) {
        Map<Character, Integer> occurences = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char letter = string.charAt(i);
            // we can do it this way too
            occurences.put(letter, occurences.getOrDefault(letter, 0) + 1);
        }
        for (int i = 0; i < string.length(); i++) {
            char letter = string.charAt(i);
            if (occurences.get(letter) == 1) {
                return i;
            }
        }
        return -1;
    }
}
