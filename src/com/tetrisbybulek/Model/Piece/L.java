package com.tetrisbybulek.Model.Piece;

import com.tetrisbybulek.Model.Block.Block;
import com.tetrisbybulek.Model.Block.SpritedBlock;

public class L extends Piece{
    /**
     * L-Shaped Piece object
     */
    static Block f = new SpritedBlock(false, Pieces.L);

    private final static Block[][] s0 = {
            {e, e, f},
            {f, f, f},
            {e, e, e},
    };
    private final static Block[][] s1 = {
            {e, f, e},
            {e, f, e},
            {e, f, f},
    };
    private final static Block[][] s2 = {
            {e, e, e},
            {f, f, f},
            {f, e, e},
    };
    private final static Block[][] s3 = {
            {f, f, e},
            {e, f, e},
            {e, f, e},
    };

    public L(Block[][] board){
        /**
         * Parameter Constructor of L object
         *
         * @param board reference to main board
         */
        super(board, s0, s1, s2, s3, Pieces.L);
    }
}
