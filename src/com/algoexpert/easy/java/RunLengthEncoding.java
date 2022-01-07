package com.algoexpert.easy.java;

public class RunLengthEncoding {
    public static void main(String[] args) {
        int[] queries = {3, 2, 1, 2, 6};
        RunLengthEncoding a = new RunLengthEncoding();
        System.out.println(a.runLengthEncoding("AAAAAAAAAAAAABBCCCCDD"));
    }

    public String runLengthEncoding(String string) {
        int currSequenceLength = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < string.length(); i++) {
            char currentLetter = string.charAt(i);
            char previousLetter = string.charAt(i -1);
            if (currentLetter != previousLetter || currSequenceLength == 9) {
                // add sequence in format 9A 4B - number of repeats and previous letter
                sb.append(currSequenceLength);
                sb.append(previousLetter);
                currSequenceLength = 0;
            }
            currSequenceLength++;
        }
        sb.append(currSequenceLength);
        sb.append(string.charAt(string.length() -1));
        return sb.toString();
    }
}
