package com.tetrisbybulek.Controller;

import com.tetrisbybulek.Model.Board;
import com.tetrisbybulek.Model.Piece.None;
import com.tetrisbybulek.Model.Piece.Pieces;
import com.tetrisbybulek.View.TetrisView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController {
    private Board board;
    boolean started;
    Timer timer;
    InputController controller;
    TetrisView tetrisView;

    public GameController(TetrisView tetrisView){
        started = true;
        board = new Board();
        board.nextPiece();
        this.tetrisView = tetrisView;
        timer = new Timer(200, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                doTick(); tetrisView.repaint();
            }
        });

        controller = new InputController(board.getCurrent());
        timer.start();
    }

    public InputController getInputController(){
        return controller;
    }

    public Board getBoard(){
        return board;
    }

    public void gameover(){
        if( board.isGameover() ){
            started = false;
            controller.isPaused = true;
            board.setCurrent(new None(board.getBoard()));
            board.clearBoard();
            tetrisView.repaint();
        }
    }

    public void doTick(){
        if( controller.isPaused && started )
            return;

        if( !started && controller.isPaused  ){
            return;
        }

        if( board.getCurrent().getPiece() == Pieces.None )
            board.nextPiece();

        if( board.getCurrent().isOnSurface() ) {
            gameover();
            clearLines();
            board.nextPiece();
            controller.setPiece(board.getCurrent());
        }
        else
            board.tick();
    }

    private int clearLines() {
        int cleared = 0;
        for (int i = 0; i < board.getBoard().length; i++) {
            boolean hasHole = false;
            for (int j = 0; j < board.getBoard()[i].length; j++) {
                hasHole ^= board.getBoard()[i][j].isEmpty();
                if (hasHole)
                    break;
            }
            if (!hasHole) {
                for (int y = i; y < 21; y++)
                    for (int j = 0; j < board.getBoard()[i].length; j++)
                        board.getBoard()[y][j] = board.getBoard()[y + 1][j];
                i--;
                cleared++;
            }
        }
        return cleared;
    }



}
