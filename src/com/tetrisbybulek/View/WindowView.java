package com.tetrisbybulek.View;

import javax.swing.*;
import java.awt.*;

public class WindowView extends JFrame {
    TetrisView tetrisView;

    public WindowView(){
        tetrisView = new TetrisView();
    }

    public void init(){
        setLayout(new BorderLayout());
        add(tetrisView, BorderLayout.CENTER);
        setSize(10*20+10, 23*20+10);
        setPreferredSize(new Dimension(10*20+10, 23*20+10));
        setTitle("Tetris");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setResizable(false);
    }
}
