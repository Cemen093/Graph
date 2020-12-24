package org.itstep.undirectedGraph;


public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        for (int i = 0; i < 7; i++) {
            graph.addVertex((char)('A' + i));
        }

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 6);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);

        System.out.println("searchWidth");
        graph.searchWidth(0);
        System.out.println("searchDepth");
        graph.searchDepth(0);
    }
}
