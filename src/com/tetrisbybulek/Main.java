package com.tetrisbybulek;

import com.tetrisbybulek.View.WindowView;

import java.awt.*;

public class Main {
    public static void main(String args[]){
        EventQueue.invokeLater(() -> {

            WindowView view = new WindowView();
            view.init();
        });
    }
}
