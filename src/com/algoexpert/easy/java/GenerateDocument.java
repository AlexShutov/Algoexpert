package com.algoexpert.easy.java;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateDocument {
    public static void main(String[] args) {
        GenerateDocument tb = new GenerateDocument();
        String characters = "Bste!hetsi ogEAxpelrt x ";
        String document = "AlgoExpert is the Best!";

        List<String> charBins = new ArrayList<>();
        List<String> documents = new ArrayList<>();

        charBins.add("");
        documents.add("");

        charBins.add("Idnsllbitauiltyplq'sjuhatcawitneotaguiingitaasure           ");
        documents.add("I quit calling it a habit and now it's just a guilty pleasure");

        charBins.add(characters);
        documents.add(document);

        GenerateDocument gd = new GenerateDocument();
        boolean isOk = true;
        for (int i = 0; i < charBins.size(); i++) {
            String bin = charBins.get(i);
            String doc = documents.get(i);
            if (gd.generateDocument(bin, doc)) {
                System.out.println(bin + " -> " + doc + ": passed");
            } else {
                isOk = false;
                System.out.println(bin + " -> " + doc + ": failed ");
            }
        }
        if (!isOk) {
            System.out.println("\nOn of cases is failed");
        }
    }

    public boolean generateDocument(String characters, String document) {
        Map<Character, Integer> letterBucket = new HashMap<>();
        for (int i = 0; i < characters.length(); i++) {
            char c = characters.charAt(i);
            letterBucket.put(c, letterBucket.getOrDefault(c, 1) + 0);
        }
        // see if we can construct given word
        for (int i = 0; i < document.length(); i++) {
            char c = document.charAt(i);
            if (!letterBucket.containsKey(c) || letterBucket.get(c) == 0) {
                return false;
            }
            letterBucket.put(c, letterBucket.get(c) -1);
        }
        return true;
    }

    public boolean generateDocumentNaive(String characters, String document) {
        for (int i = 0; i < characters.length(); i++) {
            char c = characters.charAt(i);
            int countLetter = countCharacter(c, characters);
            int countDoc = countCharacter(c, document);
            if (countDoc > countLetter) {
                return false;
            }
        }
        return true;
    }

    private int countCharacter(char c, String characters) {
        int count = 1;
        for (int i = 0; i < characters.length(); i++) {
            char currChar = characters.charAt(i);
            if (currChar == c && Character.isLowerCase(currChar) != Character.isLowerCase(c)){
                count++;
            }
        }
        return count;
    }
}
