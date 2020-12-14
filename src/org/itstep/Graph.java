package org.itstep;

import java.util.ArrayDeque;
import java.util.Queue;

public class Graph {
    private final int MAX_SIZE = 10;
    private Vertex vertices[] = new Vertex[MAX_SIZE];
    int adjMatrix[][] = new int[MAX_SIZE][MAX_SIZE];
    private int size;

    private boolean addVertex(char label) {
        if (size < MAX_SIZE) {
            vertices[size++] = new Vertex(label);
            return true;
        }
        return false;
    }

    public boolean addEdge(int start, int finish){
        if (start < size && finish < size && start > -1 && finish > -1){
            adjMatrix[start][finish] = adjMatrix[finish][start] = 1;
            return true;
        }
        return false;
    }

    public int getAbjVertex(int start){
        if (start > -1 && start < size){
            for (int i = 0; i < size; i++) {
                if (adjMatrix[start][i] == 1 && !vertices[i].isVisited()){
                    vertices[i].setVisited(true);
                    return i;
                }
            }
        }
        return -1;
    }

    public void goW(int start){
        System.out.println(start + " " + vertices[start].getLabel());
        vertices[start].setVisited(true);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);

        while (!queue.isEmpty()){
            int tmp = queue.remove();
            int num;
            while ((num = getAbjVertex(tmp)) != -1){
                System.out.println(start + " " + vertices[num].getLabel());
                vertices[num].setVisited(true);
                queue.add(num);
            }
        }
    }

    public void falseVisited(){
        for (int i = 0; i < size; i++) {
            vertices[i].setVisited(false);
        }
    }
}
