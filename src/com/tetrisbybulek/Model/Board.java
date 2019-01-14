package com.tetrisbybulek.Model;

import com.tetrisbybulek.Model.Block.Block;
import com.tetrisbybulek.Model.Block.SpritedBlock;
import com.tetrisbybulek.Model.Piece.*;

import java.util.Random;

public class Board {
    /**
     * Board class defining main Tetris board and its methods
     */
    private int cleanedLines;
    private int level;
    private int goal;

    private Piece current;

    private final Block[][] board;

    final int WIDTH = 10;
    final int HEIGHT = 22;

    private final static SpritedBlock empty = new SpritedBlock(true, Pieces.None);
    private final PieceFactory factory;

    public Board(){
        /**
         * No-Parameter Constructor of Board
         */
        this.cleanedLines = 0;
        this.level = 1;
        this.goal = 5;
        this.board = new Block[HEIGHT][WIDTH];
        clearBoard();
        this.factory = new PieceFactory(this.board);
        nextPiece();
    }

    public void clearBoard(){
        /**
         * Function used for clearing board by replacing every
         * block with empty block
         */
        for ( int i = 0; i < HEIGHT; i++ ){
            for ( int j = 0; j < WIDTH; j++ ){
                board[i][j] = empty;
            }
        }
    }

    public Piece getCurrent(){
        /**
         * Getter of current Piece
         *
         * @return current
         */
        return current;
    }
    public void setCurrent(Piece piece) {
        /**
         * Setter of current Piece
         *
         * @param piece Piece to be set as current
         */
        current = piece;
    }

    public Block[][] getBoard(){
        /**
         * Getter of main Block matrix (board)
         *
         * @return board
         */
        return board;
    }

    public void tick(){
        /**
         * Function defining what should happen every time tick with Piece
         */
        current.moveDown();
    }

    private int determineHeight() {
        /**
         * Function calculating maximum height Pieces have achieved
         *
         * @return height of Piece "tower"
         */
        for (int i = 0; i < board.length; i++)
            if (isEmptyLine(i))
                return i;
        return 22;
    }

    private boolean isEmptyLine(int y) {
        /**
         * Function used for checking if given line is empty
         *
         * @return True if line is empty, False otherwise
         */
        boolean hasBlock = false;
        for (int j = 0; j < board[y].length; j++) {
            hasBlock ^= !board[y][j].isEmpty();
            if (hasBlock)
                break;
        }
        return !hasBlock;
    }

    public boolean isGameover(){
        /**
         * Function used for cheking if game has ended
         *
         * @return True if height is >= 20, False otherwise
         */
        if( determineHeight() >= 20 )
            return true;
        return false;
    }


    public void nextPiece(){
        /**
         * Function used for creating new random Piece
         * after the old one finished falling
         */
        Random rand = new Random();
        int pieceIdx = rand.nextInt(7);
        current = factory.makePiece(pieceIdx);
    }
}
