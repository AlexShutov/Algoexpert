package com.algoexpert.hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DiykstraAlgorithm {
    public static void main(String[] args) {

        DiykstraAlgorithm da = new DiykstraAlgorithm();
        int start = 0;
        int[][][] edges = new int[][][]{
                new int[][]{{1, 7}},
                new int[][]{{2, 6}, {3, 20}, {4, 3}},
                new int[][]{{3, 14}},
                new int[][]{{4, 2}},
                new int[][]{{}},
                new int[][]{{}}
        };
        int[] distances = da.dijkstrasAlgorithm(start, edges);
        if (distances.length == 0) {
            System.out.println("Distances list is empty");
        } else {
            for (int i = 0; i < distances.length; i++) {
                System.out.print(String.valueOf(distances[i]) + " ");
            }
        }
    }

    public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
        int vertexCount = edges.length;
        int[] minDistances = new int[vertexCount];
        Arrays.fill(minDistances, Integer.MAX_VALUE);
        minDistances[start] = 0;
        Set<Integer> visited = new HashSet<>();

        while (visited.size() != vertexCount) {
            int[] vertexData = getVertexWithMinDistance(minDistances, visited);
            int vertex = vertexData[0];
            int currentMinDistance = vertexData[1];

            if (currentMinDistance == Integer.MAX_VALUE) {
                // We're at isolated vertex
                break;
            }
            // visit that vertex
            visited.add(vertex);

            // consider all edges, outgoing from current vertex
            for (int[] edge : edges[vertex]) {
                if (edge.length == 0) {
                    continue;
                }
                int destination = edge[0];
                int distanceToDestination = edge[1];

                // case 3->4 as in video explanation, when we try to go to vertex, which has minimum
                // path already
                if (visited.contains(destination)) {
                    continue;
                }

                int newPathToDestination = currentMinDistance + distanceToDestination;
                if (newPathToDestination < minDistances[destination]) {
                    minDistances[destination] = newPathToDestination;
                }
            }
        }


        int[] finalDistances = new int[minDistances.length];
        for (int i = 0; i < minDistances.length; i++) {
            int distance = minDistances[i];
            if (distance == Integer.MAX_VALUE) {
                distance = -1;
            }
            finalDistances[i] = distance;
        }

        return finalDistances;
    }

    private int[] getVertexWithMinDistance(int[] minDistances, Set<Integer> visited) {
        int currentMinDistance = Integer.MAX_VALUE;
        int vertex = -1;

        for (int currVertex = 0; currVertex < minDistances.length; currVertex++) {
            if (visited.contains(currVertex)) {
                continue;
            }

            if (minDistances[currVertex] < currentMinDistance) {
                currentMinDistance = minDistances[currVertex];
                vertex = currVertex;
            }
        }

        return new int[]{vertex, currentMinDistance};
    }
}
