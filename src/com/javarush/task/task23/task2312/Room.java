package com.javarush.task.task23.task2312;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Room {
    private int width, height;
    private Snake snake;
    private Mouse mouse;
    static public Room game;

    public Room(int width, int height, Snake snake) {
        this.width = width;
        this.height = height;
        this.snake = snake;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Snake getSnake() {
        return snake;
    }

    public Mouse getMouse() {
        return mouse;
    }
    /**
     * Основной цикл программы.
     * Тут происходят все важные действия
     */
    public void run() {
        //Создаем объект "наблюдатель за клавиатурой" и стартуем его.
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        //пока змея жива
        while (snake.isAlive()) {
            //"наблюдатель" содержит события о нажатии клавиш?
            if (keyboardObserver.hasKeyEvents()) {
                KeyEvent event = keyboardObserver.getEventFromTop();
                //Если равно символу 'q' - выйти из игры.
                if (event.getKeyChar() == 'q') return;

                //Если "стрелка влево" - сдвинуть фигурку влево
                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    snake.setDirection(SnakeDirection.LEFT);
                    //Если "стрелка вправо" - сдвинуть фигурку вправо
                else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    snake.setDirection(SnakeDirection.RIGHT);
                    //Если "стрелка вверх" - сдвинуть фигурку вверх
                else if (event.getKeyCode() == KeyEvent.VK_UP)
                    snake.setDirection(SnakeDirection.UP);
                    //Если "стрелка вниз" - сдвинуть фигурку вниз
                else if (event.getKeyCode() == KeyEvent.VK_DOWN)
                    snake.setDirection(SnakeDirection.DOWN);
            }

            snake.move();   //двигаем змею
            print();        //отображаем текущее состояние игры
            sleep();        //пауза между ходами
        }

        System.out.println("Game Over!");
    }
/*    public void print() {
        //Создаем массив, куда будем "рисовать" текущее состояние игры
        int[][] matrix = new int[height][width];

        //Рисуем все кусочки змеи
        ArrayList<SnakeSection> sections = new ArrayList<SnakeSection>(snake.getSections());
        for (SnakeSection snakeSection : sections) {
            matrix[snakeSection.getY()][snakeSection.getX()] = 1;
        }

        //Рисуем голову змеи (4 - если змея мертвая)
        matrix[snake.getY()][snake.getX()] = snake.isAlive() ? 2 : 4;

        //Рисуем мышь
        matrix[mouse.getY()][mouse.getX()] = 3;

        //Выводим все это на экран
        //String[] symbols = {" . ", " x ", " X ", "^_^", "RIP"};
        String[] symbols = {" . ", " x ", " X ", "^_^", "RIP"};
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(symbols[matrix[y][x]]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }*/
    void print () {
        int [][] screen = new int[height][width];
        for (int i=0; i<width;i++) {
            screen [0][i]=0;
            screen [height-1][i]=0;
        }
        for (int i=0; i<height;i++) {
            screen [i][0]=0;
            screen [i][width-1]=0;
        }
        screen[snake.getSections().get(0).getY()][snake.getSections().get(0).getX()]=2;
        for (int i=1;i<snake.getSections().size();i++) {
            screen[snake.getSections().get(i).getY()][snake.getSections().get(i).getX()]=1;
        }
        screen [mouse.getY()][mouse.getX()]=3;

        for (int i=0;i<height;i++) {
            for (int j=0;j<width;j++) {
                switch (screen[i][j]) {
                    case (1) :
                        System.out.print("x");
                        break;
                    case (2):
                        System.out.print("X");
                        break;
                    case (3):
                        System.out.print("^");
                        break;
                        default:
                            System.out.print(".");
                            break;
                }
            }
            System.out.println();
        }

    }

    public void createMouse () {
        mouse = new Mouse((int) (Math.random() * width), (int) (Math.random() * height));
    }

    void eatMouse () {
        createMouse();
    }

    void sleep (){
        int timeSleep;
        int snakeSize = snake.getSections().size();
        if (snakeSize>15) timeSleep=200;
            else timeSleep = (int) (500-(snake.getSections().size()-1)*20);
        try {
            Thread.sleep(timeSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Snake snake = new Snake(5,5);
        snake.setDirection(SnakeDirection.DOWN);
        game = new Room(10,10,snake);
        game.createMouse();
        game.run();

        game.print();

    }
}
