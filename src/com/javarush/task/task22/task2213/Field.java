package com.javarush.task.task22.task2213;

import java.util.ArrayList;

/**
 * Класс Field описывает "поле клеток" игры Тетрис
 */
public class Field {
    //ширина и высота
    private int width, height;
    //матрица поля: 1 - клетка занята, 0 - свободна
    private int[][] matrix;

    public Field(int height, int width) {
        this.width = width;
        this.height = height;
        this.matrix = new int[height][width];
        //initialMatrix();
    }

    public void initialMatrix () {
        for (int y=0;y<height;y++) {
            for (int x=0;x<width;x++) {
                if (y==0||y==1||y==3||y==7||y==height-1||y==height-2) matrix[y][x]=1;
                else
                if (x==y||x==height-y) matrix[y][x] =1;
                else matrix[y][x]=0;
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getMatrix() {
        return matrix;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Метод возвращает значение, которое содержится в матрице с координатами (x,y)
     * Если координаты за пределами матрицы, метод возвращает null.
     */
    public Integer getValue(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height)
            return matrix[y][x];

        return null;
    }


    /**
     * Метод устанавливает переданное значение(value) в ячейку матрицы с координатами (x,y)
     */
    public void setValue(int x, int y, int value) {
        if (x >= 0 && x < width && y >= 0 && y < height)
            matrix[y][x] = value;
    }

    /**
     * Метод печатает на экран текущее содержание матрицы
     */


    public void print() {
        //Создаем массив, куда будем "рисовать" текущее состояние игры
        int[][] canvas = new int[height][width];

        //Копируем "матрицу поля" в массив
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                canvas[i][j] = matrix[i][j];
            }
        }

        //Копируем фигурку в массив, только непустые клетки
        int left = Tetris.game.getFigure().getX();
        int top = Tetris.game.getFigure().getY();
        int[][] brickMatrix = Tetris.game.getFigure().getMatrix();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (top + i >= height || left + j >= width) continue;
                if (brickMatrix[i][j] == 1)
                    canvas[top + i][left + j] = 2;
            }
        }


        //Выводим "нарисованное" на экран, но начинаем с "границы кадра".
        System.out.println("---------------------------------------------------------------------------\n");

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int index = canvas[i][j];
                if (index == 0)
                    System.out.print(" . ");
                else if (index == 1)
                    System.out.print(" X ");
                else if (index == 2)
                    System.out.print(" X ");
                else
                    System.out.print("???");
            }
            System.out.println();
        }


        System.out.println();
        System.out.println();
    }
    /**
     * Удаляем заполненные линии
     */
    void removeFullLines() {
        /* Вариант JavaRush
         //Создаем список для хранения линий
        ArrayList<int[]> lines = new ArrayList<int[]>();

        //Копируем все непустые линии в список.
        for (int i = 0; i < height; i++) {
            //подсчитываем количество единиц в строке - просто суммируем все ее значения
            int count = 0;
            for (int j = 0; j < width; j++) {
                count += matrix[i][j];
            }

            //Если сумма строки не равна ее ширине - добавляем в список
            if (count != width)
                lines.add(matrix[i]);
        }

        //Добавляем недостающие строки в начало списка.
        while (lines.size() < height) {
            lines.add(0, new int[width]);
        }

        //Преобразуем список обратно в матрицу
        matrix = lines.toArray(new int[height][width]);
        */

        for (int y=height-1;y>=0;y--) {
            Boolean isFull=true;
            for (int x=0;x<width;x++) {
                if (matrix[y][x]==0) isFull=false;
            }
            if (isFull) {
                for (int yy=y;yy>=0;yy--) {
                    matrix[yy] = null;
                    matrix[yy] = new int[width];
                    if ((yy-1)>=0) matrix[yy] = matrix[yy - 1];
                }
                y++;
                /*for (int yy=y;yy>=0;yy--) {
                    for (int xx=0;xx<width;xx++)
                        if ((yy-1)>=0)matrix[yy][xx]=matrix[yy-1][xx];
                        else matrix[yy][xx]=0;
                }*/
            }
        }
    }



}
