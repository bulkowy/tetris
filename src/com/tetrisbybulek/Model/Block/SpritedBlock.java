package com.tetrisbybulek.Model.Block;

import com.tetrisbybulek.Model.Piece.Pieces;

public class SpritedBlock extends Block {

    Pieces pieces;

    public SpritedBlock(boolean empty, Pieces type){
        super(empty);
        pieces = type;
    }

    @Override
    public Pieces getPieces(){
        return pieces;
    }

}
