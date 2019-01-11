package com.tetrisbybulek.Model.Piece;

import com.tetrisbybulek.Model.Block.Block;

public class L extends Piece{
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
        super(board, s0, s1, s2, s3, Pieces.L);
    }
}
