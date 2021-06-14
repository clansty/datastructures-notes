package com.clansty.dstest;

public class Graph {
    int[][] adj = {
            {1, 2, 3},
            {0, 1, 3, 4},
            {0, 3, 4},
            {0, 2, 4},
            {1, 2, 3}
    };

    public void dfs() {
        var isVisited = new boolean[adj.length];
        for (int i = 0; i < adj.length; i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    private void dfs(boolean[] isVisited, int i) {
        System.out.print(i + "\t");
        isVisited[i] = true;
        i++;
        while (i < adj.length) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
            i++;
        }
    }
}
