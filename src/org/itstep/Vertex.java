package org.itstep;

public class Vertex {
    private char label;
    private boolean isVisited;

    public Vertex(char label) {
        this.label = label;
        this.isVisited = isVisited;
    }

    public char getLabel() {
        return label;
    }

    public void setLabel(char label) {
        this.label = label;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}
