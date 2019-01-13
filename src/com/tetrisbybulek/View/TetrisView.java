package com.tetrisbybulek.View;

import com.tetrisbybulek.Controller.GameController;
import com.tetrisbybulek.Model.Board;
import com.tetrisbybulek.Model.Piece.Pieces;

import javax.swing.*;
import java.awt.*;

public class TetrisView extends JComponent {
    GameController gameController;
    Board board;
    int sideSize = 20;

    public TetrisView(){
        setFocusable(true);
        gameController = new GameController(this);
        board = gameController.getBoard();
        addKeyListener(gameController.getInputController());
    }

    public void paint(Graphics g){
        for( int i = 0; i < board.getBoard().length; i++ ){
            for( int j = 0; j < board.getBoard()[i].length; j++ ){
                drawPiece(g, j, i, board.getBoard()[i][j].getPieces());
            }
        }
    }

    public void drawPiece(Graphics g, int x, int y, Pieces pieces)
    {
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
