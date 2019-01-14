package com.tetrisbybulek.Model.Piece;

import com.tetrisbybulek.Model.Block.*;


public class Piece {
    /**
     * Class defining Piece Model object
     */
    static Block e = new SpritedBlock(true, Pieces.None);

    private final Block[][][] sprites;
    private final Block[][] board;
    //private final Ghost ghost;

    private final int startX = 3;
    private final int startY = 21;
    private int rotation;
    private int x;
    private int y;
    private int ghostY;
    private Pieces type;

    public Piece(Block[][] board, Block[][] s0, Block[][] s1, Block[][] s2, Block[][] s3, Pieces type) {
        /**
         * Parameter Constructor of Piece object
         *
         * Assigns params and sets itself on board
         *
         * @param board reference to main board
         * @param s0    sprite of Piece while in rotation 0
         * @param s1    sprite of Piece while in rotation 1
         * @param s2    sprite of Piece while in rotation 2
         * @param s3    sprite of Piece while in rotation 3
         * @param type  type of new Piece
         */
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

        for( int i = 0; i < this.sprites[0].length; i++ ){
            for( int j = 0; j < this.sprites[0][i].length; j++ ){
                board[y - i][x + j] = this.sprites[0][i][j];
            }
        }
    }

    private int mod0to3(int value){
        /**
         * Function used for retrieving rotation value
         * Uses modulo 4 operation and has possibility to serve negative values
         *
         * @param value integer value to make calculations on
         * @return value % 4
         */
        if ( value < 0 ) {
            return ( 4 + value ) % 4;
        }
        else {
            return value % 4;
        }
    }

    public Pieces getPiece(){
        /**
         * Getter of Piece type
         *
         * @return type
         */
        return this.type;
    }

    private void calculateGhostY(boolean rewriteY) {
        /**
         * Function calculating lowest possible point Piece might achieve
         * going straight down
         *
         * @param rewriteY boolean to decide whether rewrite y field or not
         */
        this.ghostY = this.y;
        while ( isValid(this.x, this.ghostY - 1, this.rotation) ) {
            this.ghostY--;
            //distance++;
        }
        if ( rewriteY ) {
            this.y = this.ghostY;
        }
    }

    public void removePiece(){
        /**
         * Function used for removing current sprite from board
         * to available easy movement of Piece
         */
        Block[][] piece = this.sprites[this.rotation];
        for( int i = 0; i < piece.length; i++ ){
            for( int j = 0; j < piece[i].length; j++ ){
                if( !piece[i][j].isEmpty() )
                    this.board[y - i][x + j] = e;
            }
        }
    }

    public void updatePiece(){
        /**
         * Function used for updating board with info about
         * new localization of Piece
         */
        Block[][] piece = this.sprites[this.rotation];
        for( int i = 0; i < piece.length; i++ ){
            for( int j = 0; j < piece[i].length; j++ ){
                if( !piece[i][j].isEmpty() )
                    this.board[y - i][x + j] = piece[i][j];
            }
        }
    }

    public void rotateLeft(){
        /**
         * Function used for rotating Piece counter-clockwise
         */
        removePiece();
        if ( isValid(x, y, rotation + 1) ) {
            this.rotation = mod0to3(this.rotation - 1);
        }
        updatePiece();
    }

    public void rotateRight(){
        /**
         * Function used for rotating Piece clockwise
         */
        removePiece();
        if ( isValid(x, y, rotation + 1) ) {
            this.rotation = mod0to3(this.rotation + 1);
        }
        updatePiece();
    }

    public void moveLeft(){
        /**
         * Function used for moving Piece one block left
         */
        removePiece();
        if ( isValid(x - 1, y, rotation) ) {
            this.x = this.x - 1;
        }
        updatePiece();
    }

    public void moveRight(){
        /**
         * Function used for moving Piece one block right
         */
        removePiece();
        if ( isValid(x + 1, y, rotation) ) {
            this.x = this.x + 1;
        }
        updatePiece();
    }

    public void moveDown() {
        /**
         * Function used for moving Piece one block down
         */
        removePiece();
        if ( isValid(x, y - 1, rotation) ) {
            this.y = this.y - 1;
        }
        updatePiece();
    }

    public void dropDown() {
        /**
         * Function used for moving Piece all the way down
         * to lowest possible point it can achieve
         *
         * @see Piece#calculateGhostY(boolean)
         */
        removePiece();
        calculateGhostY(true);
        updatePiece();
    }

    protected boolean isValid(int x, int y, int rotation){
        /**
         * Function used for checking whether given move will be
         * possible to achieve
         *
         * @param x coordinate on X axis to check
         * @param y coordinate on Y axis to check
         * @param rotation which rotation of Piece should be checked
         *
         * @return True if movement possible, False otherwise
         */
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

    public boolean isOnSurface(){
        /**
         * Function used for checking whether block hit the surface
         * and its movement down is not longer possible
         *
         * @return True if cannot move down, False otherwise
         */
        removePiece();
        boolean valid = isValid(x, y - 1, rotation);
        updatePiece();
        return !valid;
    }
}
