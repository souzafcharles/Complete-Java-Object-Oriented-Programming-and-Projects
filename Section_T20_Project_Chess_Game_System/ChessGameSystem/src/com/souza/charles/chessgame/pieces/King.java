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


public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    private boolean canMove(Position position) {
        ChessPiece chessPiece = (ChessPiece) getBoard().piece(position);
        return chessPiece == null || chessPiece.getColor() != getColor();
    }

    private boolean testRookCastling(Position position) {
        ChessPiece chessPiece = (ChessPiece) getBoard().piece(position);
        return chessPiece != null && chessPiece instanceof Rook && chessPiece.getColor() == getColor() && chessPiece.getMoveCount() == 0;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] moves = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position position = new Position(0, 0);

        // above
        position.setValues(this.position.getRow() - 1, this.position.getColumn());
        if (getBoard().positionExists(position) && canMove(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        // below
        position.setValues(this.position.getRow() + 1, this.position.getColumn());
        if (getBoard().positionExists(position) && canMove(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        // left
        position.setValues(this.position.getRow(), this.position.getColumn() - 1);
        if (getBoard().positionExists(position) && canMove(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        // right
        position.setValues(this.position.getRow(), this.position.getColumn() + 1);
        if (getBoard().positionExists(position) && canMove(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        // nw
        position.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);
        if (getBoard().positionExists(position) && canMove(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        // ne
        position.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);
        if (getBoard().positionExists(position) && canMove(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        // sw
        position.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);
        if (getBoard().positionExists(position) && canMove(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        // se
        position.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);
        if (getBoard().positionExists(position) && canMove(position)) {
            moves[position.getRow()][position.getColumn()] = true;
        }

        // #specialmove castling
        if (getMoveCount() == 0 && !chessMatch.getCheck()) {
            // #specialmove castling kingside rook
            Position posT1 = new Position(this.position.getRow(), this.position.getColumn() + 3);
            if (testRookCastling(posT1)) {
                Position p1 = new Position(this.position.getRow(), this.position.getColumn() + 1);
                Position p2 = new Position(this.position.getRow(), this.position.getColumn() + 2);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
                    moves[this.position.getRow()][this.position.getColumn() + 2] = true;
                }
            }
            // #specialmove castling queenside rook
            Position posT2 = new Position(this.position.getRow(), this.position.getColumn() - 4);
            if (testRookCastling(posT2)) {
                Position p1 = new Position(this.position.getRow(), this.position.getColumn() - 1);
                Position p2 = new Position(this.position.getRow(), this.position.getColumn() - 2);
                Position p3 = new Position(this.position.getRow(), this.position.getColumn() - 3);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
                    moves[this.position.getRow()][this.position.getColumn() - 2] = true;
                }
            }
        }

        return moves;
    }

    @Override
    public String toString() {
        if ("K".equals(String.valueOf(getClass().getSimpleName().charAt(0)))) {
            return "♔";
        }
        return "K";
    }
}