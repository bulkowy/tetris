package com.tetrisbybulek.Model.Piece;

import com.tetrisbybulek.Model.Block.Block;
import com.tetrisbybulek.Model.Block.SpritedBlock;

public class None extends Piece{
    /**
     * None-Shaped Piece object
     */
    static Block f = new SpritedBlock(false, Pieces.I);

    private final static Block[][] s0 = {
            {e, e, e, e},
            {e, e, e, e},
            {e, e, e, e},
            {e, e, e, e},
    };
    private final static Block[][] s1 = {
            {e, e, e, e},
            {e, e, e, e},
            {e, e, e, e},
            {e, e, e, e},
    };
    private final static Block[][] s2 = {
            {e, e, e, e},
            {e, e, e, e},
            {e, e, e, e},
            {e, e, e, e},
    };
    private final static Block[][] s3 = {
            {e, e, e, e},
            {e, e, e, e},
            {e, e, e, e},
            {e, e, e, e},
    };

    public None(Block[][] board){
        /**
         * Parameter Constructor of Piece with no shape
         *
         * @param board reference to main board
         */
        super(board, s0, s1, s2, s3, Pieces.None);
    }
}