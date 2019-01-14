package com.tetrisbybulek.Model.Piece;

import com.tetrisbybulek.Model.Block.Block;
import com.tetrisbybulek.Model.Block.SpritedBlock;

public class T extends Piece{
    /**
     * T-Shaped Piece object
     */
    static Block f = new SpritedBlock(false, Pieces.T);

    private final static Block[][] s0 = {
            {e, f, e},
            {f, f, f},
            {e, e, e},
    };
    private final static Block[][] s1 = {
            {e, f, e},
            {e, f, f},
            {e, f, e},
    };
    private final static Block[][] s2 = {
            {e, e, e},
            {f, f, f},
            {e, f, e},
    };
    private final static Block[][] s3 = {
            {e, f, e},
            {f, f, e},
            {e, f, e},
    };

    public T(Block[][] board){
        /**
         * Parameter Constructor of T object
         *
         * @param board reference to main board
         */
        super(board, s0, s1, s2, s3, Pieces.T);
    }
}
