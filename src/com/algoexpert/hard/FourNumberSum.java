package com.algoexpert.hard;

import java.util.*;

public class FourNumberSum {

    public static void main(String[] args) {
        int[] array = new int[]{7, 6, 4, -1, 1, 2};
        int targetSum = 16;

        System.out.println(fourNumberSum(array, targetSum));
    }

    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        List<Integer[]> result = new ArrayList<>();
        // будем хранить пары сумм чисел в мапе, используя в качестве ключа их сумму
        Map<Integer, List<Integer[]>> pairsOfNumbers = new TreeMap<>();
        // будем проходиться по всем числам в массиве и проверять суммы чисел попарно
        for (int i = 1; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                // проверим, образует ли данная пара чисел array[i], array[j] четверку с другими парами
                // из истории посещения
                Integer[] currPair = new Integer[]{array[i], array[j]};
                int currSum = currPair[0] + currPair[1];
                if (pairsOfNumbers.containsKey(targetSum - currSum)) {
                    // мы нашли вхождение, пройдем по всем парам чисел из истории, добавим к ним
                    // текущую пару и сохраним четверки в результат
                    for (Integer[] pair : pairsOfNumbers.get(targetSum - currSum)) {
                        result.add(new Integer[]{pair[0], pair[1], currPair[0], currPair[1]});
                    }
                }
            }
            // теперь будем добавлять все новые пары в историю - это важно делать здесь, после основного
            // цикла, чтобы исключить повторяющихся четверок чисел
            for (int k = i-1; k >=0; k--) {
                Integer[] pair = new Integer[]{array[k], array[i]};
                int currSum = pair[0] + pair[1];
                if (!pairsOfNumbers.containsKey(currSum)) {
                    // Добавляем пару в историю
                    List<Integer[]> newList = new ArrayList<>();
                    newList.add(pair);
                    pairsOfNumbers.put(currSum, newList);
                } else {
                    // уже есть пары чисел, дающие в сумме это число, добавим к ним текущую пару
                    pairsOfNumbers.get(currSum).add(pair);
                }
            }
        }

        return result;
    }
}
