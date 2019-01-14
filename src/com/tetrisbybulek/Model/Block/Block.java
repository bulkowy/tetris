package com.tetrisbybulek.Model.Block;

import com.tetrisbybulek.Model.Piece.Pieces;

public class Block {
    /**
     * Class defining one block of tetramino
     */

    public static int width = 24;
    public static int height = 24;
    private boolean empty = false;

    public Block(){
        /**
         * No-parameter constructor for Block object
         * Calls Block constructor with empty parameter set as true
         *
         * @see Block#Block(boolean)
         */
        this(true);
    }

    public Block(boolean empty){
        /**
         * Parameter constructor for Block object
         * Sets emptiness of Block object based on given boolean parameter
         *
         * @param empty boolean telling whether Block should be treated
         *              as empty or not
         */
        this.setEmpty(empty);

    }

    public boolean isEmpty(){
        /**
         * Getter of empty field
         *
         * @return boolean value of empty field
         */
        return this.empty;
    }

    public void setEmpty(boolean empty){
        /**
         * Setter of empty field
         *
         * @param empty boolean telling whether Block should be treated
         *              as empty or not
         */
        this.empty = empty;
    }

    public Pieces getPieces(){
        /**
         * Mock function for future overriding
         */
        return null;
    }
}
