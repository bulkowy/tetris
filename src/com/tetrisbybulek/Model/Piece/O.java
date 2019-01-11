package com.tetrisbybulek.Model.Piece;

import com.tetrisbybulek.Model.Block.Block;

public class O extends Piece{
    private final static Block[][] s0 = {
            {e, f, f, e},
            {e, f, f, e},
            {e, e, e, e},
            {e, e, e, e},
    };
    private final static Block[][] s1 = {
            {e, f, f, e},
            {e, f, f, e},
            {e, e, e, e},
            {e, e, e, e},
    };
    private final static Block[][] s2 = {
            {e, f, f, e},
            {e, f, f, e},
            {e, e, e, e},
            {e, e, e, e},
    };
    private final static Block[][] s3 = {
            {e, f, f, e},
            {e, f, f, e},
            {e, e, e, e},
            {e, e, e, e},
    };

    public O(Block[][] board){
        super(board, s0, s1, s2, s3, Pieces.O);
    }
}
