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

public class Knight extends ChessPiece {

    public Knight(Board board, Color color) {
        super(board, color);
    }

    private boolean canMove(Position position) {
        ChessPiece chessPiece = (ChessPiece)getBoard().piece(position);
        return chessPiece == null || chessPiece.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] moves = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position position = new Position(0, 0);

        position.setValues(this.position.getRow() - 1, this.position.getColumn() - 2);
        if (getBoard().positionExists(position) && canMove(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        position.setValues(this.position.getRow() - 2, this.position.getColumn() - 1);
        if (getBoard().positionExists(position) && canMove(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        position.setValues(this.position.getRow() - 2, this.position.getColumn() + 1);
        if (getBoard().positionExists(position) && canMove(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        position.setValues(this.position.getRow() - 1, this.position.getColumn() + 2);
        if (getBoard().positionExists(position) && canMove(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        position.setValues(this.position.getRow() + 1, this.position.getColumn() + 2);
        if (getBoard().positionExists(position) && canMove(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        position.setValues(this.position.getRow() + 2, this.position.getColumn() + 1);
        if (getBoard().positionExists(position) && canMove(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        position.setValues(this.position.getRow() + 2, this.position.getColumn() - 1);
        if (getBoard().positionExists(position) && canMove(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        position.setValues(this.position.getRow() + 1, this.position.getColumn() - 2);
        if (getBoard().positionExists(position) && canMove(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        return moves;
    }

    @Override
    public String toString() {
        if ("Knight".equals(getClass().getSimpleName())) {
            return "♘";
        }
        return "N";
    }
}