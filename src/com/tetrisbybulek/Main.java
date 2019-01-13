package com.tetrisbybulek;

import com.tetrisbybulek.Model.Board;
import com.tetrisbybulek.View.TetrisView;
import com.tetrisbybulek.View.WindowView;

import java.awt.*;

public class Main {
    public static void main(String args[]){
        EventQueue.invokeLater(() -> {

            WindowView view = new WindowView();
            view.init();
        });



        /*for( int i = 0; i < 4; i++ ){
            piece.rotateLeft();
            piece.moveLeft();
            piece.printSprite();
            board.printBoard();;
        }
        for( int i = 0; i < 4; i++ ){
            piece.rotateRight();
            piece.moveRight();
            piece.printSprite();
            board.printBoard();
        }*/
    }
}
