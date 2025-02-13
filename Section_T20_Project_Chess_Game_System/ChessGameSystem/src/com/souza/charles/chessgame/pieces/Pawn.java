package com.souza.charles.chessgame.pieces;
/*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: February 13, 2025
*/

import com.souza.charles.boardgame.Board;
import com.souza.charles.boardgame.Position;
import com.souza.charles.chessgame.ChessMatch;
import com.souza.charles.chessgame.ChessPiece;
import com.souza.charles.chessgame.Color;

public class Pawn extends ChessPiece {

    private ChessMatch chessMatch;

    public Pawn(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] moves = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position position = new Position(0, 0);

        if (getColor() == Color.RED) {
            position.setValues(this.position.getRow() - 1, this.position.getColumn());
            if (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
                moves[position.getRow()][position.getColumn()] = true;
            }
            position.setValues(this.position.getRow() - 2, this.position.getColumn());
            Position p2 = new Position(this.position.getRow() - 1, this.position.getColumn());
            if (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
                moves[position.getRow()][position.getColumn()] = true;
            }
            position.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);
            if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
                moves[position.getRow()][position.getColumn()] = true;
            }
            position.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);
            if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
                moves[position.getRow()][position.getColumn()] = true;
            }

            // #specialmove en passant white
            if (this.position.getRow() == 3) {
                Position left = new Position(this.position.getRow(), this.position.getColumn() - 1);
                if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
                    moves[left.getRow() - 1][left.getColumn()] = true;
                }
                Position right = new Position(this.position.getRow(), this.position.getColumn() + 1);
                if (getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
                    moves[right.getRow() - 1][right.getColumn()] = true;
                }
            }
        }
        else {
            position.setValues(this.position.getRow() + 1, this.position.getColumn());
            if (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
                moves[position.getRow()][position.getColumn()] = true;
            }
            position.setValues(this.position.getRow() + 2, this.position.getColumn());
            Position p2 = new Position(this.position.getRow() + 1, this.position.getColumn());
            if (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
                moves[position.getRow()][position.getColumn()] = true;
            }
            position.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);
            if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
                moves[position.getRow()][position.getColumn()] = true;
            }
            position.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);
            if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
                moves[position.getRow()][position.getColumn()] = true;
            }

            // #specialmove en passant black
            if (this.position.getRow() == 4) {
                Position left = new Position(this.position.getRow(), this.position.getColumn() - 1);
                if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
                    moves[left.getRow() + 1][left.getColumn()] = true;
                }
                Position right = new Position(this.position.getRow(), this.position.getColumn() + 1);
                if (getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
                    moves[right.getRow() + 1][right.getColumn()] = true;
                }
            }
        }
        return moves;
    }

    @Override
    public String toString() {
        if ("P".equals(String.valueOf(getClass().getSimpleName().charAt(0)))) {
            return "♙";
        }
        return "P";
    }
}