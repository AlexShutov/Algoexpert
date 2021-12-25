package com.algoexpert.easy;

public class RunLengthEncoding {
    public static void main(String[] args) {
        int[] queries = {3, 2, 1, 2, 6};
        RunLengthEncoding a = new RunLengthEncoding();
        System.out.println(a.runLengthEncoding("AAAAAAAAAAAAABBCCCCDD"));
    }

    public String runLengthEncoding(String string) {
        StringBuilder sb = new StringBuilder();
        int runLength = 1;
        for (int i = 1; i < string.length(); i++) {
            char currChar = string.charAt(i);
            char prevChar = string.charAt(i -1);
            if ((currChar != prevChar) || runLength == 9) {
                sb.append(runLength);
                sb.append(prevChar);
                runLength = 0;
            }
            runLength++;
        }
        sb.append(runLength);
        sb.append(string.charAt(string.length() -1));

        return sb.toString();
    }
}
