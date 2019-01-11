package com.tetrisbybulek.Model.Piece;

import com.tetrisbybulek.Model.Block.*;


public class Piece {
    static Block e = new Block(true);
    static Block f = new Block(false);

    private final Block[][][] sprites;
    private final Block[][] board;
    //private final Ghost ghost;

    private final int startX = 3;
    private final int startY = 10;
    private int rotation;
    private int x;
    private int y;
    private int ghostY;
    private Pieces type;

    public Piece(Block[][] board, Block[][] s0, Block[][] s1, Block[][] s2, Block[][] s3, Pieces type) {
        this.sprites = new Block[4][s0.length][s0.length];
        this.sprites[0] = s0;
        this.sprites[1] = s1;
        this.sprites[2] = s2;
        this.sprites[3] = s3;
        this.board = board;

        this.rotation = 0;
        this.x = startX;
        this.y = startY;

        this.type = type;
    }

    private int mod0to3(int value){
        if ( value < 0 ) {
            return ( 4 + value ) % 4;
        }
        else {
            return value % 4;
        }
    }

    public Pieces getPiece(){
        return this.type;
    }

    private void calculateGhostY(boolean rewriteY) {
        //int distance = 0;
        this.ghostY = this.y;
        while ( isValid(this.x, this.ghostY - 1, this.rotation) ) {
            this.ghostY--;
            //distance++;
        }
        if ( this.ghostY != y )
            putGhost();
        if ( rewriteY ) {
            this.y = this.ghostY;
        }
        //return distance;
    }

    private void putGhost(){
        return;
    }

    public void removePiece(){
        Block[][] piece = this.sprites[this.rotation];
        for( int i = 0; i < piece.length; i++ ){
            for( int j = 0; j < piece[i].length; j++ ){
                if( !piece[i][j].isEmpty() )
                    this.board[y - i][x + j] = e;
            }
        }
    }

    public void updatePiece(){
        Block[][] piece = this.sprites[this.rotation];
        for( int i = 0; i < piece.length; i++ ){
            for( int j = 0; j < piece[i].length; j++ ){
                if( !piece[i][j].isEmpty() )
                    this.board[y - i][x + j] = piece[i][j];
            }
        }
    }

    public void rotateLeft(){
        removePiece();
        if ( isValid(x, y, rotation + 1) ) {
            this.rotation = mod0to3(this.rotation - 1);
        }
        updatePiece();
    }

    public void rotateRight(){
        removePiece();
        if ( isValid(x, y, rotation + 1) ) {
            this.rotation = mod0to3(this.rotation + 1);
        }
        updatePiece();
    }

    public void moveLeft(){
        removePiece();
        if ( isValid(x - 1, y, rotation) ) {
            this.x = this.x - 1;
        }
        updatePiece();
    }

    public void moveRight(){
        removePiece();
        if ( isValid(x + 1, y, rotation) ) {
            this.x = this.x + 1;
        }
        updatePiece();
    }

    public void moveDown() {
        removePiece();
        if ( isValid(x, y - 1, rotation) ) {
            this.y = this.y - 1;
        }
        updatePiece();
    }

    public void dropDown() {
        removePiece();
        calculateGhostY(true);
        updatePiece();
    }

    public void printSprite(){
        System.out.println(Integer.toString(this.rotation));

        for (Block b[] : this.sprites[this.rotation]){
            for (Block _b : b){
                System.out.print(Boolean.toString((_b.isEmpty())) + '\t');
            }
            System.out.println();
        }
    }

    protected boolean isValid(int x, int y, int rotation){
        rotation = mod0to3(rotation);
        Block[][] piece = this.sprites[rotation];
        if(!( x >= -piece.length && x <= 9) || !( y >= 0 && y <= 21 )) return false;



        for( int i = 0; i < piece.length; i++ ){
            for( int j = 0; j < piece[i].length; j++ ){
                int boardx = x + j;
                int boardy = y - i;
                if(!piece[i][j].isEmpty() &&
                    (boardx > 9 || boardx < 0 || boardy > 21 || boardy < 0
                    || !this.board[boardy][boardx].isEmpty())){
                    return false;}
            }
        }
        return true;
    }

    protected boolean isOnSurface(){
        removePiece();
        boolean valid = isValid(x, y - 1, rotation);
        updatePiece();
        return !valid;
    }
}
