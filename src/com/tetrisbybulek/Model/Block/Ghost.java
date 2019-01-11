package com.tetrisbybulek.Model.Block;

public class Ghost extends Block {

    public Ghost(){
        super(true);
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
