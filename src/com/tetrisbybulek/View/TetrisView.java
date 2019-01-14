package com.tetrisbybulek.View;

import com.tetrisbybulek.Controller.GameController;
import com.tetrisbybulek.Model.Board;
import com.tetrisbybulek.Model.Piece.Pieces;

import javax.swing.*;
import java.awt.*;

public class TetrisView extends JComponent {
    /**
     * TetrisView class that is child of JComponent
     * Serves as renderer of every Tetris model
     */
    GameController gameController;
    Board board;
    int sideSize = 20;

    public TetrisView(){
        /**
         * No-Parameter Constructor of TetrisView object
         */
        setFocusable(true);
        gameController = new GameController(this);
        board = gameController.getBoard();
        addKeyListener(gameController.getInputController());
    }

    public void paint(Graphics g){
        /**
         * Function used to paint whole board with respect to existing blocks
         *
         * @param g Graphics object
         */
        for( int i = 0; i < board.getBoard().length; i++ ){
            for( int j = 0; j < board.getBoard()[i].length; j++ ){
                drawBlock(g, j, i, board.getBoard()[i][j].getPieces());
            }
        }
    }

    private void drawBlock(Graphics g, int x, int y, Pieces pieces) {
        /**
         * Function used for drawing single Block with color related to its type
         *
         * @param g Graphics object
         * @param x Coordinate at X axis
         * @param y Coordinate at Y axis
         * @param pieces type of Block
         */
        Color colors[] = { new Color(204, 102, 102),
                new Color(102, 204, 102), new Color(102, 102, 204),
                new Color(204, 204, 102), new Color(204, 102, 204),
                new Color(102, 204, 204), new Color(218, 170, 0), new Color(0, 0, 0)
        };

        Color color = colors[pieces.ordinal()];
        x = sideSize * x;
        y = sideSize * (21 - y);

        g.setColor(color);
        g.fillRect(x + 1, y + 1, sideSize - 2, sideSize - 2);

        g.setColor(color.brighter());
        g.drawLine(x, y + sideSize - 1, x, y);
        g.drawLine(x, y, x + sideSize - 1, y);

        g.setColor(color.darker());
        g.drawLine(x + 1, y + sideSize - 1,
                x + sideSize - 1, y + sideSize - 1);
        g.drawLine(x + sideSize - 1, y + sideSize - 1,
                x + sideSize - 1, y + 1);
    }
}
