package com.tetrisbybulek.Controller;

import com.tetrisbybulek.Model.Piece.Piece;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputController extends KeyAdapter implements KeyListener{
        /**
         * Class defining InputController object used for listening for user input
         */
    private Piece piece;
    boolean isPaused;

    public InputController(Piece piece){
        /**
         * Parameter Constructor of InputController object
         *
         * @param piece currently served Piece on Tetris Board
         */
        this.piece = piece;
        isPaused = false;
    }

    private void pause(){
        /**
         * Function changing status of pause
         */
        isPaused = !isPaused;
    }

    public void setPiece(Piece newPiece){
        /**
         * Setter of piece field
         *
         * @param newPiece Piece object to be assigned to piece field
         */
        piece = newPiece;
    }

    @Override
    public void keyPressed(KeyEvent e){
        /**
         * Override of default keyPressed function
         *
         * Defines most important movements for gameplay
         *
         * @param e KeyEvent used for catching user input
         */
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_P)
            pause();

        if ( isPaused )
            return;

        if (key == KeyEvent.VK_LEFT)
            piece.moveLeft();

        if (key == KeyEvent.VK_RIGHT)
            piece.moveRight();

        if (key == KeyEvent.VK_UP)
            piece.rotateRight();

        if (key == KeyEvent.VK_Z)
            piece.rotateLeft();

        if (key == KeyEvent.VK_X)
            piece.rotateRight();

        if (key == KeyEvent.VK_DOWN)
            piece.moveDown();

        if (key == KeyEvent.VK_SPACE)
            piece.dropDown();
    }
}
