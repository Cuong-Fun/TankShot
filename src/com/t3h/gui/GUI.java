package com.t3h.gui;

import javax.swing.*;
import java.util.List;

public class GUI extends JFrame {
    private MyPanel myPanel;

    public GUI(){
        setSize(800, 800);
        setLocationRelativeTo(null);
        //setTitle("GUI");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        myPanel = new MyPanel();
        add(myPanel);
        setTitle("Test Push");
    }
}
