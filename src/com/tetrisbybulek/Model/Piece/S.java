package com.tetrisbybulek.Model.Piece;

import com.tetrisbybulek.Model.Block.Block;
import com.tetrisbybulek.Model.Block.SpritedBlock;

public class S extends Piece{
    /**
     * S-Shaped Piece object
     */
    static Block f = new SpritedBlock(false, Pieces.S);

    private final static Block[][] s0 = {
            {e, f, f},
            {f, f, e},
            {e, e, e},
    };
    private final static Block[][] s1 = {
            {e, f, e},
            {e, f, f},
            {e, e, f},
    };
    private final static Block[][] s2 = {
            {e, e, e},
            {e, f, f},
            {f, f, e},
    };
    private final static Block[][] s3 = {
            {f, e, e},
            {f, f, e},
            {e, f, e},
    };

    public S(Block[][] board){
        /**
         * Parameter Constructor of S object
         *
         * @param board reference to main board
         */
        super(board, s0, s1, s2, s3, Pieces.S);
    }
}
