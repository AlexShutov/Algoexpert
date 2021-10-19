package com.algoexpert.medium;

import java.util.*;

public class RiverSizes {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0}
        };
        List<Integer> sizes = riverSizes(matrix);
        Collections.sort(sizes);
        System.out.println(sizes);
    }

    public static List<Integer> riverSizes(int[][] matrix) {
        List<Integer> sizes = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (visited[i][j]) continue;

                visitNode(i, j, matrix, visited, sizes);
            }
        }

        return sizes;
    }

    private static void visitNode(int i, int j, int[][] matrix, boolean[][] visited, List<Integer> sizes) {
        // начали обход новой вершины, мы или выйдем, или же найдем последовательность какой-то длины
        int riverLength = 0;
        Deque<Point> nodesToVisit = new ArrayDeque<>();
        // пусть ищем в ширину
        nodesToVisit.addLast(new Point(i, j));
        while (!nodesToVisit.isEmpty()) {
            Point currNode = nodesToVisit.removeFirst();
            // пропускаем уже посещенные вершины
            if (visited[currNode.row][currNode.col]) {
                continue;
            }
            // начинаем обходить эту вершину
            visited[currNode.row][currNode.col] = true;
            // учитываем вершины с 1, с 0- пропускаем
            if (matrix[currNode.row][currNode.col] != 1) continue;
            // сейчас находимся в новой (не обойденной раньше) вершине реки с 1, увеличиваем счетчик длины реки
            riverLength++;
            // смотрим, куда идти дальше
            List<Point> neighboringNodes = getNotVisitedNeighbors(currNode, visited);
            // Добавляем соседний вершины в очередь
            for (Point neighbor : neighboringNodes) {
                nodesToVisit.addLast(neighbor);
            }
        }
        // закончили обход данной вершины и всех соседних, если нужно, можем
        // можем добавить длину реки
        if (riverLength != 0) {
            sizes.add(riverLength);
        }
    }

    private static List<Point> getNotVisitedNeighbors(Point currNode, boolean[][] visited) {
        List<Point> neighbors = new ArrayList<>();
        // добавляем левого соседа когда он есть (индекс >0)
        if (currNode.col >= 1 && !visited[currNode.row][currNode.col -1]) {
            neighbors.add(new Point(currNode.row, currNode.col - 1));
        }
        // добавляем верхнего соседа, есть его строка как минимум 1
        if (currNode.row >= 1 && !visited[currNode.row -1][currNode.col]) {
            neighbors.add(new Point(currNode.row -1, currNode.col));
        }
        // добавляем правого соседа, если индекс колонки не последний
        if (currNode.col < visited[0].length - 1 && !visited[currNode.row][currNode.col +1]) {
            neighbors.add(new Point(currNode.row, currNode.col +1));
        }
        // добавляем нижнего соседа, если индекс строки не последний
        if (currNode.row < visited.length -1 && !visited[currNode.row +1][currNode.col]) {
            neighbors.add(new Point(currNode.row + 1, currNode.col));
        }

        return neighbors;
    }

    static class Point {
        public int row;
        public int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
