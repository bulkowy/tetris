package com.tetrisbybulek.Model;

import com.tetrisbybulek.Model.Block.Block;
import com.tetrisbybulek.Model.Piece.*;

public class Board {
    // queue?
    private int cleanedLines;
    private int level;
    private int goal;

    // time here or in controller?

    private Piece current;
    private Piece hold; // if enough time -> implement

    private final Block[][] board;

    final int WIDTH = 10;
    final int HEIGHT = 22;
    // pixel values?

    private final static Block empty = new Block(true);

    // combo?

    public Board(){
        this.cleanedLines = 0;
        this.level = 1;
        this.goal = 5;
        this.board = new Block[HEIGHT][WIDTH];
        for ( int i = 0; i < HEIGHT; i++ ){
            for ( int j = 0; j < WIDTH; j++ ){
                board[i][j] = empty;
            }
        }
    }

    public Block[][] getBoard(){
        return board;
    }

    public void printBoard(){

        for (Block b[] : this.board){
            for (Block _b : b){
                System.out.print(Boolean.toString((_b.isEmpty())) + "\t");
            }
            System.out.println();
        }
    }

    // todo board
}
