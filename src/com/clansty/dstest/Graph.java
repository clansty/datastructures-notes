package com.clansty.dstest;

import java.util.ArrayList;
import java.util.LinkedList;

class Graph {
    private ArrayList vertexList;
    private int[][] edges;
    private int numOfEdges;

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList(n);
        numOfEdges = 0;
    }

    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    private void depthFirstSearch(boolean[] isVisited, int i) {
        System.out.print(i + "  ");
        isVisited[i] = true;

        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                depthFirstSearch(isVisited, w);
            }
            w = getNextNeighbor(i, w);
        }
    }

    public void depthFirstSearch() {
        var isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                depthFirstSearch(isVisited, i);
            }
        }
    }

    private void broadFirstSearch(boolean[] isVisited, int i) {
        int u, w;
        LinkedList queue = new LinkedList();

        System.out.print(i + "  ");
        isVisited[i] = true;
        queue.addLast(i);
        while (!queue.isEmpty()) {
            u = ((Integer) queue.removeFirst()).intValue();
            w = getFirstNeighbor(u);
            while (w != -1) {
                if (!isVisited[w]) {
                    System.out.print(w + "  ");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                w = getNextNeighbor(u, w);
            }
        }
    }

    public void broadFirstSearch() {
        var isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                broadFirstSearch(isVisited, i);
            }
        }
    }
}