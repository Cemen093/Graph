package org.itstep.directedGraph;

import java.util.*;

//Реализовать класс графа
public class Graph {
    private final int MAX_SIZE = 10;
    private final Vertex[] vertices = new Vertex[MAX_SIZE];
    //Связи представить в виде матрицы смежности
    int[][] edgeMatrix = new int[MAX_SIZE][MAX_SIZE];
    private int size;

    public void addVertex(char label) {
        //Предусмотреть возможость добавления новых вершин
        if (size < MAX_SIZE) {
            vertices[size++] = new Vertex(label);
        }
    }

    public void addEdge(int start, int finish) {
        //Предусмотреть возможость добавления новых и дуг
        if (start < size && finish < size && start > -1 && finish > -1) {
            //Граф ориентированный
            edgeMatrix[start][finish] = 1;
        }
    }

    //чет длинноватое получилось название, но ничего получше придумать не смог
    private int getIndexFirstVisibleAndNotVisitedVertexOrMinusOneIfNot(int start) {
        if (start > -1 && start < size) {
            for (int i = 0; i < size; i++) {
                if (edgeMatrix[start][i] == 1 && !vertices[i].isVisited()) {
                    return i;
                }
            }
        }
        return -1;
    }

    private void setFalseVisitedForAllVertex() {
        for (int i = 0; i < size; i++) {
            vertices[i].setVisited(false);
        }
    }

    public void searchDepth(int start) {
        //Предусмотреть возможость обхода графа в глубину
        setFalseVisitedForAllVertex();
        searchDepthReal(start);
    }

    private void searchDepthReal(int current) {
        if (current >= MAX_SIZE || current < 0){
            return;
        }

        //Выводим текущию вершину
        System.out.print("(" + current + " " + vertices[current].getLabel() + "), ");
        vertices[current].setVisited(true);

        //Составляем очередь вершин которых мы видим и отмечаем их как посещенные
        Queue<Integer> queue = new ArrayDeque<>();
        int indexVisibleVertex;
        while ((indexVisibleVertex = getIndexFirstVisibleAndNotVisitedVertexOrMinusOneIfNot(current)) != -1) {
            queue.add(indexVisibleVertex);
            vertices[indexVisibleVertex].setVisited(true);
        }

        //рекурсивный вызов для тех вершин которые мы видим от меньшей к большей
        while (!queue.isEmpty()) {
            searchDepthReal(queue.poll());
        }
    }


    public void topologicalSort(int start) {
        //Добавить в класс графа метод топологической сортировки
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(edgeMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n");

        for (int i = 0; i < size; i++) {
            System.out.print("(index " + i + ", Ver " + vertices[i].getLabel() + "), ");
        }
        System.out.println("\n");

        setFalseVisitedForAllVertex();
        Stack<Vertex> stack = new Stack<>();
                makeStackForTopologicalSort(start, stack);
        for (int i = 0; i < size; i++) {
            vertices[i] = stack.pop();
        }

        for (int i = 0; i < size; i++) {
            System.out.print("(index " + i + ", Ver " + vertices[i].getLabel() + "), ");
        }
        System.out.println("\n");
    }


    private void makeStackForTopologicalSort(int current, Stack<Vertex> stack) {
        if (current >= MAX_SIZE || current < 0){
            throw new RuntimeException("Выход за пределы массива Vertex");
        }

        //Составляем очередь вершин которых мы видим и отмечаем их как посещенные
        Queue<Integer> queue = new ArrayDeque<>();
        int indexVisibleVertex;
        while ((indexVisibleVertex = getIndexFirstVisibleAndNotVisitedVertexOrMinusOneIfNot(current)) != -1) {
            queue.add(indexVisibleVertex);
            vertices[indexVisibleVertex].setVisited(true);
        }

        //рекурсивный вызов для тех вершин которые мы видим от меньшей к большей
        while (!queue.isEmpty()) {
            makeStackForTopologicalSort(queue.poll(), stack);
        }
        stack.push(vertices[current]);
    }
}
