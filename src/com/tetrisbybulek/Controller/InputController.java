package com.tetrisbybulek.Controller;

import com.tetrisbybulek.Model.Piece.Piece;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputController extends KeyAdapter implements KeyListener {
    private Piece piece;
    boolean isPaused;

    public InputController(Piece piece){
        this.piece = piece;
        isPaused = false;
    }

    private void pause(){
        isPaused = !isPaused;
    }

    public void setPiece(Piece newPiece){
        piece = newPiece;
    }

    @Override
    public void keyPressed(KeyEvent e){
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
