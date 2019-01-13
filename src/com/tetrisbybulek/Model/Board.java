package com.tetrisbybulek.Model;

import com.tetrisbybulek.Model.Block.Block;
import com.tetrisbybulek.Model.Block.SpritedBlock;
import com.tetrisbybulek.Model.Piece.*;

import java.util.Random;

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

    private final static SpritedBlock empty = new SpritedBlock(true, Pieces.None);
    private final PieceFactory factory;

    // combo?

    public Board(){
        this.cleanedLines = 0;
        this.level = 1;
        this.goal = 5;
        this.board = new Block[HEIGHT][WIDTH];
        clearBoard();
        this.factory = new PieceFactory(this.board);
        nextPiece();
    }

    public void clearBoard(){
        for ( int i = 0; i < HEIGHT; i++ ){
            for ( int j = 0; j < WIDTH; j++ ){
                board[i][j] = empty;
            }
        }
    }

    public Piece getCurrent(){
        return current;
    }
    public void setCurrent(Piece piece) { current = piece; }

    public Piece getHold(){
        return hold;
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

    public void tick(){
        current.moveDown();
    }

    private int determineHeight() {
        for (int i = 0; i < board.length; i++)
            if (isEmptyLine(i))
                return i;
        return 22;
    }

    private boolean isEmptyLine(int y) {
        boolean hasBlock = false;
        for (int j = 0; j < board[y].length; j++) {
            hasBlock ^= !board[y][j].isEmpty();
            if (hasBlock)
                break;
        }
        return !hasBlock;
    }

    public boolean isGameover(){
        if( determineHeight() >= 20 )
            return true;
        return false;
    }


    public void nextPiece(){
        Random rand = new Random();
        int pieceIdx = rand.nextInt(7);
        current = factory.makePiece(pieceIdx);
    }

    public void touchSurface(){
        if( !current.isOnSurface() ) {
            return;
        }
        nextPiece();
    }

    // todo board
}
