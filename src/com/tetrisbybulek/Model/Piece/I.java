package com.tetrisbybulek.Model.Piece;

import com.tetrisbybulek.Model.Block.Block;

public class I extends Piece{
    private final static Block[][] s0 = {
            {e, e, e, e},
            {f, f, f, f},
            {e, e, e, e},
            {e, e, e, e},
    };
    private final static Block[][] s1 = {
            {e, e, f, e},
            {e, e, f, e},
            {e, e, f, e},
            {e, e, f, e},
    };
    private final static Block[][] s2 = {
            {e, e, e, e},
            {e, e, e, e},
            {f, f, f, f},
            {e, e, e, e},
    };
    private final static Block[][] s3 = {
            {e, f, e, e},
            {e, f, e, e},
            {e, f, e, e},
            {e, f, e, e},
    };

    public I(Block[][] board){
        super(board, s0, s1, s2, s3, Pieces.I);
    }
}
