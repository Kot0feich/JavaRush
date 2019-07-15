package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public Snake(int x, int y) {
        sections = new ArrayList<SnakeSection>();
        sections.add(new SnakeSection(x,y));
        /*sections.add(new SnakeSection(x+1,y));
        sections.add(new SnakeSection(x+2,y));*/
        isAlive = true;
    }
    public int getX() {
        return sections.get(0).getX();
    }
    public int getY() {
        return sections.get(0).getY();
    }


    void move (int x, int y) {

        int newX=sections.get(0).getX()+x;
        int newY=sections.get(0).getY()+y;
        //SnakeSection head = sections.get(0);
        SnakeSection head = new SnakeSection(newX,newY);
        checkBorders(head);
        checkBody(head);
        if (!isAlive) {
            sections.add(0,new SnakeSection(newX,newY));
            if (sections.get(0).getX()==Room.game.getMouse().getX()&&sections.get(0).getY()==Room.game.getMouse().getY()) {
                Room.game.eatMouse();
            }
            else sections.remove(sections.size()-1);
        }

    }
    void move () {
        if (isAlive()) {
            switch (direction) {
                case UP: move (0,-1);
                    break;
                case DOWN:move (0,1);
                    break;
                case LEFT:move(-1,0);
                    break;
                case RIGHT:move(1,0);
                    break;
            }
        }
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public List<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }
    public void checkBorders(SnakeSection head) {
        if (head.getX()<0 ||
                head.getX()>Room.game.getWidth()-1||
                head.getY()<0||
                head.getY()>Room.game.getHeight()-1) isAlive=false;

    }
    public void checkBody(SnakeSection head) {
        if (sections.contains(head)) isAlive=false;
    }

}
