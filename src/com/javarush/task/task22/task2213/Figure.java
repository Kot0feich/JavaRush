package com.javarush.task.task22.task2213;

public class Figure {
    private int x,y;
    private int[][] matrix;

    public Figure(int x, int y, int[][] matrix) {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
    void left(){
        if (isCurrentPositionAvailable()) this.x--;
    }
    void right(){
        if (isCurrentPositionAvailable())this.x++;
    }
    void down(){
        if (isCurrentPositionAvailable()) this.y++;
    }
    void up(){
        if (isCurrentPositionAvailable()) this.y--;
    }
    void rotate(){}
    void downMaximum(){}
    boolean isCurrentPositionAvailable() {
        return true;
    }
    void landed(){};
}
