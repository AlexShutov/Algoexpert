package com.algoexpert.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> getPermutationsHighMemoryAlloc(List<Integer> array) {
        List<List<Integer>> permutations = new ArrayList<>();
        addPermutationItem(array, new ArrayList<>(), permutations);

        return permutations;
    }

    private static void addPermutationItem(List<Integer> remainingItems, List<Integer> currPermutation,
                                           List<List<Integer>> permutations) {
        // была ошибка - в случае пустого массива нужно вернуть пустой массив, а не массив с пустым массивом
        if (remainingItems.isEmpty() && !currPermutation.isEmpty()) {
            // больше не осталось чисел, которые нужно переставить - известна перестановка, \
            // добавляем ее в список всех перестновок
            permutations.add(new ArrayList<>(currPermutation));
        } else {
            // будем выбирать по-очереди оставшиеся числа и доавлять их в текущую перестановку
            for (int i = 0; i < remainingItems.size(); i++) {
                int currNumber = remainingItems.get(i);
                // скопируем оставшиеся числа и удалим из них текущее - да, будет требоваться больше памяти
                List<Integer> remainingCopy = new ArrayList<>(remainingItems);
                // удалим это число из списка, использующегося на следующем шаге
                remainingCopy.remove(i);
                // На следующий шаг нужно передать копию текущей перестановки, т.к. эта перестановка зависиь от
                // значения, выбранного на данном шаге
                List<Integer> currPermutationCopy = new ArrayList<>(currPermutation);
                currPermutationCopy.add(currNumber);
                // на следующем шаге будем обрабатывать перестановку без текущего элемента, передаем
                // копию массивов оставшихся чисел и текущей перестановки
                addPermutationItem(remainingCopy, currPermutationCopy, permutations);
            }
        }
    }

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        // будем продвигаться по массиву и сначала переставлять местами по 2 числа, затем идти дальше рекурсивно,
        // а затем, после этого вызова, возвращать числа обратно
        List<List<Integer>> permutations = new ArrayList<>();
        permutationStep(0, new ArrayList<>(array), permutations);

        return permutations;
    }

    private static void permutationStep(int i, List<Integer> array, List<List<Integer>> resultPermutations) {
        // сначала проверим - если мы дошли до конца массива, нужно зафиксировать перестановку -
        // добавить ее в нужный массив
        if (i == array.size() -1) {
            resultPermutations.add(new ArrayList<>(array));
            return;
        }
        // проходим по всем остальным числам, начиная с i, а не! с i+1 - в первый проход ничего не переставляем.
        // Затем вычисляем для них перестановки
        for (int j = i; j < array.size(); j++) {
            // меняем местами i и j числа
            swap(array, i, j);
            // Затем обрабатываем таким же образом оставшуюся часть массива, начиная с i + 1
            permutationStep(i + 1, array, resultPermutations);
            // и в конце, после того, как обработали все числа для данного шага рекурсивно,
            // меняем числа обратно - делаем еще одну замену
            swap(array, i, j);
        }
    }

    private static void swap(List<Integer> array, int i, int j) {
        int tmp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, tmp);
    }
}
