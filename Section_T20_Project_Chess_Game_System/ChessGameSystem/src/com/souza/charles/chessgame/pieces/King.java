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
        return "K";
    }
}
