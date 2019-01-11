package com.tetrisbybulek;

import com.tetrisbybulek.Model.Board;
import com.tetrisbybulek.Model.Piece.*;

public class Main {
    public static void main(String args[]){
        Board board = new Board();
        Piece piece = new L(board.getBoard());
        System.out.println(Integer.toString(piece.getPiece().ordinal()));
        piece.printSprite();
        piece.moveLeft();
        piece.dropDown();
        board.printBoard();
        piece = new L(board.getBoard());
        piece.printSprite();
        piece.moveLeft();
        piece.moveLeft();
        piece.rotateLeft();
        piece.rotateLeft();

        piece.moveDown();
        piece.moveDown();
        piece.moveDown();
        piece.moveDown();
        piece.moveDown();
        piece.moveDown();
        piece.moveDown();
        piece.moveDown();
        piece.moveDown();

        board.printBoard();

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
