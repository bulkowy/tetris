package com.tetrisbybulek.Model.Piece;

import com.tetrisbybulek.Model.Block.Block;

public class PieceFactory {
    /**
     * Class defining creation of new Pieces
     */

    private final Pieces[] pieces;
    Block[][] board;

    public PieceFactory(Block[][] board){
        /**
         * Parameter Constructor of PieceFactory object
         *
         * @param board reference to main board
         */
        this.pieces = Pieces.values();
        this.board = board;
    }

    public Piece makePiece(int pieceType){
        /**
         * Function returning Piece depending on given type
         *
         * @param pieceType type of requested Piece
         */
        if ( pieceType == Pieces.I.ordinal() )
            return new I(board);
        else if ( pieceType == Pieces.J.ordinal() )
            return new J(board);
        else if ( pieceType == Pieces.L.ordinal() )
            return new L(board);
        else if ( pieceType == Pieces.O.ordinal() )
            return new O(board);
        else if ( pieceType == Pieces.S.ordinal() )
            return new S(board);
        else if ( pieceType == Pieces.T.ordinal() )
            return new T(board);
        else if ( pieceType == Pieces.Z.ordinal() )
            return new Z(board);
        else
            return null;
    }
}
