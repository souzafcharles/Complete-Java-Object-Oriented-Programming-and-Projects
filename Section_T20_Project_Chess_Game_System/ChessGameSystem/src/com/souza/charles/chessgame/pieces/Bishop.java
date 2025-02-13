package com.souza.charles.chessgame.pieces;
/*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: February 13, 2025
*/

import com.souza.charles.boardgame.Board;
import com.souza.charles.boardgame.Position;
import com.souza.charles.chessgame.ChessPiece;
import com.souza.charles.chessgame.Color;

public class Bishop extends ChessPiece {

    public Bishop(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] moves = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position position = new Position(0, 0);

        // nw
        position.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            moves[position.getRow()][position.getColumn()] = true;
            position.setValues(position.getRow() - 1, position.getColumn() - 1);
        }
        if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        // ne
        position.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            moves[position.getRow()][position.getColumn()] = true;
            position.setValues(position.getRow() - 1, position.getColumn() + 1);
        }
        if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        // se
        position.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            moves[position.getRow()][position.getColumn()] = true;
            position.setValues(position.getRow() + 1, position.getColumn() + 1);
        }
        if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        // sw
        position.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            moves[position.getRow()][position.getColumn()] = true;
            position.setValues(position.getRow() + 1, position.getColumn() - 1);
        }
        if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        return moves;
    }

    @Override
    public String toString() {
        if ("B".equals(String.valueOf(getClass().getSimpleName().charAt(0)))) {
            return "♗";
        }
        return "B";
    }
}
