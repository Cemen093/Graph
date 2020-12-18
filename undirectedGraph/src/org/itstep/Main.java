package org.itstep;


public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        for (int i = 0; i < 4; i++) {
            graph.addVertex((char)('A' + i));
        }

/*        graph.addEdge(0, 1, 3);
        graph.addEdge(0, 4,5);
        graph.addEdge(1, 2,5);
        graph.addEdge(1, 3,2);
        graph.addEdge(2, 3,1);
        graph.addEdge(3, 4,1);

        int start = 0;
        int[] result = graph.getMinPaths(start);
        for (int i = 0; i < result.length; i++) {
            System.out.println("from " + start +" to " + i + " length is " + result[i]);
        }*/

        graph.addArc(0, 3);
        graph.addArc(3, 1);
        graph.addArc(3, 2);

        graph.topologySort(0);
    }
}
