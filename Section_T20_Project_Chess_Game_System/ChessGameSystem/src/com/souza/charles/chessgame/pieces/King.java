package com.souza.charles.chessgame.pieces;

import com.souza.charles.boardgame.Board;
import com.souza.charles.chessgame.ChessPiece;
import com.souza.charles.chessgame.Color;

import java.io.Serializable;

public class King extends ChessPiece implements Serializable {

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "♚";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        return mat;
    }
}
