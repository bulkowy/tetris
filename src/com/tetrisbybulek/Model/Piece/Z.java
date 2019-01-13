package com.tetrisbybulek.Model.Piece;

import com.tetrisbybulek.Model.Block.Block;
import com.tetrisbybulek.Model.Block.SpritedBlock;

public class Z extends Piece{
    static Block f = new SpritedBlock(false, Pieces.Z);

    private final static Block[][] s0 = {
            {f, f, e},
            {e, f, f},
            {e, e, e},
    };
    private final static Block[][] s1 = {
            {e, e, f},
            {e, f, f},
            {e, f, e},
    };
    private final static Block[][] s2 = {
            {e, e, e},
            {f, f, e},
            {e, f, f},
    };
    private final static Block[][] s3 = {
            {e, f, e},
            {f, f, e},
            {f, e, e},
    };

    public Z(Block[][] board){
        super(board, s0, s1, s2, s3, Pieces.Z);
    }
}
