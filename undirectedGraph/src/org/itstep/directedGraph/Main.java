package org.itstep.directedGraph;


public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex('0');
        graph.addVertex('1');
        graph.addVertex('2');
        graph.addVertex('3');

        graph.addEdge(0, 3);
        graph.addEdge(3, 1);
        graph.addEdge(3, 2);

        System.out.println("topologicalSort from 0");
        graph.topologicalSort(0);
    }
}
