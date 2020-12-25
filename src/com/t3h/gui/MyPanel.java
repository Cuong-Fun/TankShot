package com.t3h.gui;

import com.t3h.gui.model.Tank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class MyPanel extends JPanel implements KeyListener {
    private List<Tank> tanks;
    private Tank tank;
    private boolean isLeft, isRight, isUp, isDown, isSpace;

    public MyPanel() {

        tanks = new ArrayList<>();
//        initTanks();
        tank = new Tank(100, 100, 100, Color.CYAN, Tank.UP);
        //tank.setDelay(20);
        setFocusable(true);
        requestFocus();
        addKeyListener(this);

    initThread();
    }

    private void initTanks() {

        tanks.add(
                new Tank(50, 10, 100, Color.RED, Tank.RIGHT)
        );
        tanks.add(new Tank(50, 150, 100, Color.RED, Tank.LEFT));
        tanks.add(new Tank(400, 350, 100, Color.RED, Tank.UP));
        tanks.add(new Tank(250, 150, 100, Color.RED, Tank.LEFT));
        tanks.add(new Tank(250, 350, 100, Color.RED, Tank.DOWN));
        tanks.add(new Tank(350, 350, 100, Color.BLUE, Tank.UP));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        //mot so method cua Graphic2D
        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        Image img = new ImageIcon(
                MyPanel.class.getResource(
                        "/img/tankkk.jpg"
                )
        ).getImage();
        g2d.drawImage(img, 0, 0,800, 800, null);

//
//        g2d.setColor(Color.RED);
//        g2d.drawRect(50, 50, 100, 200);
//        g2d.drawOval(200, 200, 200, 200);
//        g2d.fillOval(200, 400, 200, 200);

//        for (Tank tank : tanks) {
//            tank.draw();
//        }

        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).draw(g2d);
        }
        tank.draw(g2d);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //de lay ma cua phim
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_LEFT:
                isLeft = true;
                break;
            case KeyEvent.VK_UP:
                isUp = true;
//                tank.setY(tank.getY() - 5);
//                tank.setOri(Tank.UP);
                break;
            case KeyEvent.VK_RIGHT:
                isRight = true;
//                tank.setX(tank.getX() + 5);
//                tank.setOri(Tank.RIGHT);
                break;
            case KeyEvent.VK_DOWN:
                isDown = true;
//                tank.setY(tank.getY() + 5);
//                tank.setOri(Tank.DOWN);
                break;
            case KeyEvent.VK_SPACE:
                //ban dan
                isSpace = true;
                tank.fireBullet();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //de lay ma cua phim
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_LEFT:
                isLeft = false;
                break;
            case KeyEvent.VK_UP:
                isUp = false;
                break;
            case KeyEvent.VK_RIGHT:
                isRight = false;
                break;
            case KeyEvent.VK_DOWN:
                isDown = false;
                break;
            case KeyEvent.VK_SPACE:
                //ban dan
                isSpace = false;

                break;
        }
    }

    private void initThread() {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                //noi dung thuc hien thread
                //chay song song voi Main thread
                while (true) {
                    tank.moveAllBullet();
                    moveTank();
                    if (isSpace){
                        tank.fireBullet();
                    }
                    repaint();
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread th = new Thread(run);
        th.start();
    }
    private void moveTank(){
        if (isLeft) {
            tank.setOri(Tank.LEFT);
            tank.move();
        }
        if (isUp) {
            tank.setOri(Tank.UP);
            tank.move();
        }
        if (isRight) {
            tank.setOri(Tank.RIGHT);
            tank.move();
        }
        if (isDown) {
            tank.setOri(Tank.DOWN);
            tank.move();
        }
    }
}
