package com.tetrisbybulek.Model.Block;

import com.tetrisbybulek.Model.Piece.Pieces;

public class Ghost extends SpritedBlock {
    /**
     * Class defining Ghost type of SpritedBlock
     */

    public Ghost(){
        /**
         * No-parameter constructor of Ghost object
         *
         * Calls constructor of superclass with:
         * empty set as true
         * type set as Pieces.None
         *
         * @see SpritedBlock#SpritedBlock(boolean, Pieces)
         * @see Pieces#None
         */
        super(true, Pieces.None);
    }

    @Override
    public boolean isEmpty() {
        /**
         * Override of getter of empty field
         *
         * @return always true, as Ghost object is always empty
         */
        return true;
    }

    @Override
    public void setEmpty(boolean empty) {
        /**
         * Override of setter of empty field
         *
         * Does basically nothing
         *
         * @param empty boolean telling whether Block should be treated
         *              as empty or not
         *
         */
        return;
    }
}
