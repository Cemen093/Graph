package org.itstep;

import java.util.ArrayDeque;
import java.util.Queue;

public class Graph {
    private final int MAX_SIZE = 10;
    private Vertex vertices[] = new Vertex[MAX_SIZE];
    int adjMatrix[][] = new int[MAX_SIZE][MAX_SIZE];
    private int size;

    public boolean addVertex(char label) {
        if (size < MAX_SIZE) {
            vertices[size++] = new Vertex(label);
            return true;
        }
        return false;
    }

    public boolean addEdge(int start, int finish) {
        if (start < size && finish < size && start > -1 && finish > -1) {
            adjMatrix[start][finish] = adjMatrix[finish][start] = 1;
            return true;
        }
        return false;
    }

    public boolean addEdge(int start, int finish, int weight) {
        if (start < size && finish < size && start > -1 && finish > -1) {
            adjMatrix[start][finish] = adjMatrix[finish][start] = weight;
            return true;
        }
        return false;
    }

    public int[] getMinPaths(int start){
        int[] distance = new int[size];
        for (int i = 0; i < size; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[start] = 0;
        //обойти смежные
        //если не аощена - анализ пути
        //пометить посещение
        //найти минимальное
        return distance;
    }

    public int getAbjVertex(int start) {
        if (start > -1 && start < size) {
            for (int i = 0; i < size; i++) {
                if (adjMatrix[start][i] == 1 && !vertices[i].isVisited()) {
                    //vertices[i].setVisited(true);//по моему это строка лишняя, мы в методе BreadthFirstSearch тоже ставим true
                    return i;
                }
            }
        }
        return -1;
    }

    public void searchWidth(int start) {
        System.out.println(start + " " + vertices[start].getLabel());
        vertices[start].setVisited(true);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            int num;
            while ((num = getAbjVertex(tmp)) != -1) {
                System.out.println(start + " " + vertices[num].getLabel());
                vertices[num].setVisited(true);
                queue.add(num);
            }
        }

        falseVisited();
    }

    public void searchDepth(int current) {
        //Выводим текущию вершину
        System.out.println(current + " " + vertices[current].getLabel());
        vertices[current].setVisited(true);

        //Составляем очередь вершин которых мы видим и отмечаем из как посещенные
        Queue<Integer> queue = new ArrayDeque<>();
        int num;
        while ((num = getAbjVertex(current)) != -1) {
            queue.add(num);
            vertices[num].setVisited(true);
        }

        //рекурсивный вызов для тех вершин которые мы видим от меньшей к мольшей
        while (!queue.isEmpty()) {
            searchDepth(queue.poll());

        }
    }

    public void falseVisited() {
        for (int i = 0; i < size; i++) {
            vertices[i].setVisited(false);
        }
    }
}
