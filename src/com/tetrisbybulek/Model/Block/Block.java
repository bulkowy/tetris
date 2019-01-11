package com.tetrisbybulek.Model.Block;

public class Block {
    public static int width = 24;
    public static int height = 24;
    private boolean empty = false;

    public Block(){
        this(true);
    }

    public Block(boolean empty){
        this.setEmpty(empty);
    }

    public boolean isEmpty(){
        return this.empty;
    }

    public void setEmpty(boolean empty){
        this.empty = empty;
    }
}
