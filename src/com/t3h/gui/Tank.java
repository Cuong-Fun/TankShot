package com.t3h.gui;

import javax.swing.*;
import java.awt.*;

public class Tank {
    public static final int LEFT = 0;
    public static final int UP = 1;
    public static final int RIGHT = 2;
    public static final int DOWN = 3;

    private int x, y;
    private int size;
    private Color color;
    private int ori;
    public Tank(int x, int y, int size, Color color, int ori) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        this.ori = ori;
    }

    public Tank() {

    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fillRect(x, y, size, size);
        int sizeL = size / 3;
        switch (ori) {
            case LEFT:
                int xL = x - sizeL;
                int yL = y + (size - sizeL) / 2;
                g2d.fillRect(xL, yL, sizeL, sizeL);
                break;
            case UP:
                xL = x + (size - sizeL) / 2;
                yL = y - sizeL;
                g2d.fillRect(xL, yL, sizeL, sizeL);
                break;
            case RIGHT:
                xL = x + size;
                yL = y + (size - sizeL) / 2;
                g2d.fillRect(xL, yL, sizeL, sizeL);
                break;

            case DOWN:
                xL = x + (size - sizeL) / 2;
                yL = y + size;
                g2d.fillRect(xL, yL, sizeL, sizeL);
                break;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
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
}
