package com.algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MoveElementsToEnd {

    /**
     * {"arrayOne": [-1, 5, 10, 20, 3], "arrayTwo": [26, 134, 135, 15, 17]}
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[]{2, 1, 2, 2, 2, 3, 4, 2};
        List<Integer> list = new ArrayList<>();
        for (int n : array) list.add(n);
        int toMove = 2;

        System.out.println(list.toString());
        System.out.println(moveElementToEnd(list, toMove));
    }

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int idxL = 0;
        int idxR = array.size() -1;
        while (idxL < idxR) {
            if (array.get(idxL) == toMove) {
                // нашли совпадение, перемещаем в конец
                swap(idxL, idxR, array);
                idxR--;
            } else {
                idxL++;
            }
        }
        return array;
    }

    private static void swap(int idx1, int idx2, List<Integer> list) {
        int t = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, t);
    }
}
