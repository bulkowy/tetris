package com.tetrisbybulek.Model.Piece;

import com.tetrisbybulek.Model.Block.Block;

public class J extends Piece{
    private final static Block[][] s0 = {
            {f, e, e},
            {f, f, f},
            {e, e, e},
    };
    private final static Block[][] s1 = {
            {e, f, f},
            {e, f, e},
            {e, f, e},
    };
    private final static Block[][] s2 = {
            {e, e, e},
            {f, f, f},
            {e, e, f},
    };
    private final static Block[][] s3 = {
            {e, f, e},
            {e, f, e},
            {f, f, e},
    };

    public J(Block[][] board){
        super(board, s0, s1, s2, s3, Pieces.J);
    }
}
