package com.t3h.gui.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tank extends ObjMovable{
    protected List<Bullet> bullets;
    private long lastTimeFireBullet;

    public Tank(int x, int y, int size, Color color, int ori) {
        bullets = new ArrayList<>();
        this.x = x;
        this.y = y;
        this.w = size;
        this.h = size;
        this.color = color;
        this.ori = ori;
    }

    public Tank() {
        bullets = new ArrayList<>();
    }

    @Override
    public void draw(Graphics2D g2d) {
        super.draw(g2d);
        int sizeL = w / 3;
        switch (ori) {
            case LEFT:
                int xL = x - sizeL;
                int yL = y + (w - sizeL) / 2;
                g2d.fillRect(xL, yL, sizeL, sizeL);
                break;
            case UP:
                xL = x + (w - sizeL) / 2;
                yL = y - sizeL;
                g2d.fillRect(xL, yL, sizeL, sizeL);
                break;
            case RIGHT:
                xL = x + w;
                yL = y + (w - sizeL) / 2;
                g2d.fillRect(xL, yL, sizeL, sizeL);
                break;

            case DOWN:
                xL = x + (w - sizeL) / 2;
                yL = y + w;
                g2d.fillRect(xL, yL, sizeL, sizeL);
                break;
        }

        for ( int i = 0; i < bullets.size(); i++){
            bullets.get(i).draw(g2d);
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getOri() {
        return ori;
    }

    public void setOri(int ori) {
        this.ori = ori;
    }

    public void fireBullet() {
        long current = System.currentTimeMillis();
        if ( current - lastTimeFireBullet < 1000){
            return;
        }
        lastTimeFireBullet=current;

        Bullet b = new Bullet();
        b.ori = ori;
        b.setDelay(delay/2);
        int sizeB = w/3;
        switch (ori){
            case LEFT:
                b.x =  x-2*sizeB;
                b.y =  y+(w-sizeB)/2;
                break;
            case UP:
                b.x =  x+(w-sizeB)/2;
                b.y =  y-2*sizeB;
                break;
            case RIGHT:
                b.x =  x+w+sizeB;
                b.y =  y+(w-sizeB)/2;
                break;
            case DOWN:
                b.x =  x+(w-sizeB)/2;
                b.y =  y+w + sizeB;
                break;
        }
        b.w = sizeB;
        b.h = sizeB;
        Random rd = new Random();
        Color c = new Color(
                rd.nextInt(256),
                rd.nextInt(256),
                rd.nextInt(256)
        );
        b.color=c;
        bullets.add(b);
    }

    public void moveAllBullet() {
        for ( int i = 0; i < bullets.size(); i++){
            bullets.get(i).move();

        }
    }
}
