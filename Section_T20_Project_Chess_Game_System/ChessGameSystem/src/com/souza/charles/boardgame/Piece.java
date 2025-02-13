package com.souza.charles.boardgame;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: February 12, 2025
 */

public abstract class Piece {

    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        position = null;
    }

    protected Board getBoard() {
        return board;
    }

    public abstract boolean[][] possibleMoves();

    public boolean possibleMove(Position position) {
        return possibleMoves()[position.getRow()][position.getColumn()];
    }

    public boolean isThereAnyPossibleMove() {
        boolean[][] moves = possibleMoves();
        for (int i=0; i<moves.length; i++) {
            for (int j=0; j<moves.length; j++) {
                if (moves[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}