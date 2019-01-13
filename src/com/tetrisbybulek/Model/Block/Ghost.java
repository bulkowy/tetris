package com.tetrisbybulek.Model.SpritedBlock;

import com.tetrisbybulek.Model.Block.SpritedBlock;
import com.tetrisbybulek.Model.Piece.Pieces;

public class Ghost extends SpritedBlock {

    public Ghost(){
        super(true, Pieces.None);
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public void setEmpty(boolean empty) {
        return;
    }
}
