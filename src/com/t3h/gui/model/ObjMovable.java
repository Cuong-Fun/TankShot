package com.t3h.gui.model;

public class ObjMovable extends Obj2D{
    public static final int LEFT = 0;
    public static final int UP = 1;
    public static final int RIGHT = 2;
    public static final int DOWN = 3;
    protected int ori;


    protected int delay = 2;
    protected long lastTimeMove;

    public void move(){
        long current = System.currentTimeMillis();
        if ( current - lastTimeMove < delay){
            return;
        }
        lastTimeMove = current;
        switch (ori){
            case LEFT:
                x-=2;
                break;
            case UP:
                y-=2;
                break;
            case RIGHT:
                x+=2;
                break;
            case DOWN:
                y+=2;
                break;
            default:
                break;

        }
    }

    public int getOri() {
        return ori;
    }

    public void setOri(int ori) {
        this.ori = ori;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
}
