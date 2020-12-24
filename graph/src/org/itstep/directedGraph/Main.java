package org.itstep.directedGraph;


public class Main {
    public static void main(String[] args) {
        //В Main продемонстрировать все возможности работы с реализованным графом.
        Graph graphOne = new Graph();

        for (int i = 0; i < 5; i++) {
            graphOne.addVertex((char)('A' + i));
        }

        graphOne.addEdge(0, 1);
        graphOne.addEdge(1, 2);
        graphOne.addEdge(2, 0);
        graphOne.addEdge(2, 3);
        graphOne.addEdge(3, 4);
        graphOne.addEdge(4, 2);

        System.out.println();
        System.out.println("searchDepth for 0");
        graphOne.searchDepth(0);
        System.out.println();

        System.out.println();
        System.out.println("searchDepth for 2");
        graphOne.searchDepth(2);
        System.out.println();

        System.out.println();
        System.out.println("searchDepth for 4");
        graphOne.searchDepth(4);
        System.out.println();


        Graph graphTwo = new Graph();

        graphTwo.addVertex('0');
        graphTwo.addVertex('1');
        graphTwo.addVertex('2');
        graphTwo.addVertex('3');

        graphTwo.addEdge(0, 3);
        graphTwo.addEdge(3, 1);
        graphTwo.addEdge(3, 2);

        System.out.println();
        System.out.println("topologicalSort from 0");
        graphTwo.topologicalSort(0);
    }
}
