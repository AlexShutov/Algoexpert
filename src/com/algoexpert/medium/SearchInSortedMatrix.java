package com.algoexpert.medium;

public class SearchInSortedMatrix {

    public static void main(String[] args) {

    }

    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        // поставим точку в правый верхний угол матрицы
        int row = 0;
        int column = matrix[0].length - 1;
        // будем обходить матрицу, пока не окажемся в левой нижней точке
        while (row < matrix.length && column >= 0) {
            int currValue = matrix[row][column];
            if (target < currValue) {
                // идем влево по матрице, теперь не нужно будет идти вправо и вниз
                column--;
            } else if (target > currValue) {
                // вправо мы идти не можем, т.к. начали с правого верхнего угла матрицы,
                // идем вниз
                row++;
            } else {
                // нашли число
                return new int[]{row, column};
            }
        }
        // Возврашаем, если ничего не нашлось
        return new int[]{-1, -1};
    }
}
