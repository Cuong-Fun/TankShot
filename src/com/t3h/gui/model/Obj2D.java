package com.t3h.gui.model;

import java.awt.*;

public class Obj2D {
    protected int x, y;
    protected int w, h;
    protected Color color = Color.RED;

    public void draw(Graphics2D g2d){
        g2d.setColor(color);
        g2d.fillRect(x, y, w, h);
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

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
