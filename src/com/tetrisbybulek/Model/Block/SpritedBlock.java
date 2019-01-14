package com.tetrisbybulek.Model.Block;

import com.tetrisbybulek.Model.Piece.Pieces;

public class SpritedBlock extends Block {
    /**
     * Class defining SpritedBlock object that has defined
     * type so it can print with given colors on Frame
     */

    Pieces pieces;

    public SpritedBlock(boolean empty, Pieces type){
        /**
         * Parameter Constructor of SpritedBlock object
         *
         * Calls Parameter Constructor of superclass with passed empty
         *
         * @param empty boolean telling whether Block should be treated
         *              as empty or not
         * @param type  Pieces enum type defining type of given block
         *
         * @see Block#Block(boolean)
         */
        super(empty);
        pieces = type;
    }

    @Override
    public Pieces getPieces(){
        /**
         * Getter of pieces field
         *
         * @return value of pieces field
         */
        return pieces;
    }

}
