package com.algoexpert.easy.java;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClassPhotos {
    public static void main(String[] args) {
        ArrayList<Integer> redShirtsList = new ArrayList<>(List.of(5, 8, 1, 3, 4));
        ArrayList<Integer> blueShirtsList = new ArrayList<>(List.of(6, 9, 2, 4, 5));
        ClassPhotos cp = new ClassPhotos();
        System.out.println(cp.classPhotos(redShirtsList, blueShirtsList));
    }

    public boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        Collections.sort(redShirtHeights, Comparator.reverseOrder());
        Collections.sort(blueShirtHeights, Comparator.reverseOrder());
        List<Integer> firstChildrenRow;
        List<Integer> secondChildrenRow;
        // check the tallest person and use group (red or blue) as a second row
        if (redShirtHeights.get(0) >= blueShirtHeights.get(0)) {
            secondChildrenRow = redShirtHeights;
            firstChildrenRow = blueShirtHeights;
        } else {
            secondChildrenRow = blueShirtHeights;
            firstChildrenRow = redShirtHeights;
        }
        for (int i = 0; i < secondChildrenRow.size(); i++) {
            if (firstChildrenRow.get(i) >= secondChildrenRow.get(i)) {
                return false;
            }
        }
        return true;
    }
}
