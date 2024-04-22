package com.ezyxip.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Algorithm {
    int[][] graph;
    public Algorithm(int[][] graph){
        this.graph = graph;
    }

    public int getDiameter(){
        ArrayList<Integer[]> dists = new ArrayList<>();
        for(int i = 0; i < graph.length; i++){
            dists.add(Arrays.stream(dijkstra(i)).boxed().toArray(Integer[]::new));
        }
        return dists.stream()
                .map(e -> Arrays.stream(e).max(Integer::compareTo))
                .map(Optional::orElseThrow)
                .max(Integer::compareTo)
                .orElseThrow();
    }
    public int[] dijkstra(int start) {
        int n = graph.length;
        int[] distance = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        distance[start] = 0;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = getMinIndex(distance, visited);
            visited[minIndex] = true;

            for (int j = 0; j < n; j++) {
                if (!visited[j] && graph[minIndex][j] != 0 && distance[minIndex] != Integer.MAX_VALUE
                        && distance[minIndex] + graph[minIndex][j] < distance[j]) {
                    distance[j] = distance[minIndex] + graph[minIndex][j];
                }
            }
        }

        return distance;
    }

    private int getMinIndex(int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && distance[i] <= min) {
                min = distance[i];
                minIndex = i;
            }
        }

        return minIndex;
    }
}
