package com.souza.charles.chessgame;

import com.souza.charles.boardgame.Board;
import com.souza.charles.boardgame.Piece;
import com.souza.charles.boardgame.Position;
import com.souza.charles.chessgame.pieces.*;

import java.util.ArrayList;
import java.util.List;

public class ChessMatch {

    private int turn;
    private Color currentPlayer;
    private Board board;
    private boolean check;
    private boolean checkMate;
    private ChessPiece enPassantVulnerable;
    private ChessPiece promoted;

    private List<Piece> piecesOnTheBoard = new ArrayList<>();
    private List<Piece> capturedPieces = new ArrayList<>();

    public ChessMatch() {
        board = new Board(8, 8);
        turn = 1;
        currentPlayer = Color.RED;
        initialSetup();
    }

    public int getTurn() {
        return turn;
    }

    public Color getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean getCheck() {
        return check;
    }

    public boolean getCheckMate() {
        return checkMate;
    }

    public ChessPiece getEnPassantVulnerable() {
        return enPassantVulnerable;
    }

    public ChessPiece getPromoted() {
        return promoted;
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] chessPieces = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i=0; i<board.getRows(); i++) {
            for (int j=0; j<board.getColumns(); j++) {
                chessPieces[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return chessPieces;
    }

    public boolean[][] possibleMoves(ChessPosition sourcePosition) {
        Position position = sourcePosition.toPosition();
        validateSourcePosition(position);
        return board.piece(position).possibleMoves();
    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        validateTargetPosition(source, target);
        Piece capturedPiece = makeMove(source, target);

        if (testCheck(currentPlayer)) {
            undoMove(source, target, capturedPiece);
            throw new ChessException("You can't put yourself in check! Train Again.");
        }

        ChessPiece movedPiece = (ChessPiece)board.piece(target);

        // #specialmove promotion
        promoted = null;
        if (movedPiece instanceof Pawn) {
            if ((movedPiece.getColor() == Color.RED && target.getRow() == 0) || (movedPiece.getColor() == Color.BLUE && target.getRow() == 7)) {
                promoted = (ChessPiece)board.piece(target);
                promoted = replacePromotedPiece("Q");
            }
        }

        check = (testCheck(opponent(currentPlayer))) ? true : false;

        if (testCheckMate(opponent(currentPlayer))) {
            checkMate = true;
        }
        else {
            nextTurn();
        }

        // #specialmove en passant
        if (movedPiece instanceof Pawn && (target.getRow() == source.getRow() - 2 || target.getRow() == source.getRow() + 2)) {
            enPassantVulnerable = movedPiece;
        }
        else {
            enPassantVulnerable = null;
        }

        return (ChessPiece)capturedPiece;
    }

    public ChessPiece replacePromotedPiece(String type) {
        if (promoted == null) {
            throw new IllegalStateException("There is no piece to be promoted! Train Again.");
        }
        if (!type.equals("B") && !type.equals("N") && !type.equals("R") & !type.equals("Q")) {
            return promoted;
        }

        Position pos = promoted.getChessPosition().toPosition();
        Piece piece = board.removePiece(pos);
        piecesOnTheBoard.remove(piece);

        ChessPiece newPiece = newPiece(type, promoted.getColor());
        board.placePiece(newPiece, pos);
        piecesOnTheBoard.add(newPiece);

        return newPiece;
    }

    private ChessPiece newPiece(String type, Color color) {
        if (type.equals("B")) return new Bishop(board, color);
        if (type.equals("N")) return new Knight(board, color);
        if (type.equals("Q")) return new Queen(board, color);
        return new Rook(board, color);
    }

    private Piece makeMove(Position source, Position target) {
        ChessPiece chessPiece = (ChessPiece)board.removePiece(source);
        chessPiece.increaseMoveCount();
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(chessPiece, target);

        if (capturedPiece != null) {
            piecesOnTheBoard.remove(capturedPiece);
            capturedPieces.add(capturedPiece);
        }

        // #specialmove castling kingside rook
        if (chessPiece instanceof King && target.getColumn() == source.getColumn() + 2) {
            Position sourceT = new Position(source.getRow(), source.getColumn() + 3);
            Position targetT = new Position(source.getRow(), source.getColumn() + 1);
            ChessPiece rook = (ChessPiece)board.removePiece(sourceT);
            board.placePiece(rook, targetT);
            rook.increaseMoveCount();
        }

        // #specialmove castling queenside rook
        if (chessPiece instanceof King && target.getColumn() == source.getColumn() - 2) {
            Position sourceT = new Position(source.getRow(), source.getColumn() - 4);
            Position targetT = new Position(source.getRow(), source.getColumn() - 1);
            ChessPiece rook = (ChessPiece)board.removePiece(sourceT);
            board.placePiece(rook, targetT);
            rook.increaseMoveCount();
        }

        // #specialmove en passant
        if (chessPiece instanceof Pawn) {
            if (source.getColumn() != target.getColumn() && capturedPiece == null) {
                Position pawnPosition;
                if (chessPiece.getColor() == Color.RED) {
                    pawnPosition = new Position(target.getRow() + 1, target.getColumn());
                }
                else {
                    pawnPosition = new Position(target.getRow() - 1, target.getColumn());
                }
                capturedPiece = board.removePiece(pawnPosition);
                capturedPieces.add(capturedPiece);
                piecesOnTheBoard.remove(capturedPiece);
            }
        }

        return capturedPiece;
    }

    private void undoMove(Position source, Position target, Piece capturedPiece) {
        ChessPiece chessPiece = (ChessPiece)board.removePiece(target);
        chessPiece.decreaseMoveCount();
        board.placePiece(chessPiece, source);

        if (capturedPiece != null) {
            board.placePiece(capturedPiece, target);
            capturedPieces.remove(capturedPiece);
            piecesOnTheBoard.add(capturedPiece);
        }

        // #specialmove castling kingside rook
        if (chessPiece instanceof King && target.getColumn() == source.getColumn() + 2) {
            Position sourceT = new Position(source.getRow(), source.getColumn() + 3);
            Position targetT = new Position(source.getRow(), source.getColumn() + 1);
            ChessPiece rook = (ChessPiece)board.removePiece(targetT);
            board.placePiece(rook, sourceT);
            rook.decreaseMoveCount();
        }

        // #specialmove castling queenside rook
        if (chessPiece instanceof King && target.getColumn() == source.getColumn() - 2) {
            Position sourceT = new Position(source.getRow(), source.getColumn() - 4);
            Position targetT = new Position(source.getRow(), source.getColumn() - 1);
            ChessPiece rook = (ChessPiece)board.removePiece(targetT);
            board.placePiece(rook, sourceT);
            rook.decreaseMoveCount();
        }

        // #specialmove en passant
        if (chessPiece instanceof Pawn) {
            if (source.getColumn() != target.getColumn() && capturedPiece == enPassantVulnerable) {
                ChessPiece pawn = (ChessPiece)board.removePiece(target);
                Position pawnPosition;
                if (chessPiece.getColor() == Color.RED) {
                    pawnPosition = new Position(3, target.getColumn());
                }
                else {
                    pawnPosition = new Position(4, target.getColumn());
                }
                board.placePiece(pawn, pawnPosition);
            }
        }
    }

    private void validateSourcePosition(Position position) {
        if (!board.thereIsAPiece(position)) {
            throw new ChessException("There is no piece on source position! Train Again.");
        }
        if (currentPlayer != ((ChessPiece)board.piece(position)).getColor()) {
            throw new ChessException("The chosen piece is not yours! Train Again.");
        }
        if (!board.piece(position).isThereAnyPossibleMove()) {
            throw new ChessException("There is no possible moves for the chosen piece! Train Again.");
        }
    }

    private void validateTargetPosition(Position source, Position target) {
        if (!board.piece(source).possibleMove(target)) {
            throw new ChessException("The chosen piece can't move to target position! Train Again.");
        }
    }

    private void nextTurn() {
        turn++;
        currentPlayer = (currentPlayer == Color.RED) ? Color.BLUE : Color.RED;
    }

    private Color opponent(Color color) {
        return (color == Color.RED) ? Color.BLUE : Color.RED;
    }

    private ChessPiece king(Color color) {
        List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor() == color).toList();
        for (Piece piece : list) {
            if (piece instanceof King) {
                return (ChessPiece)piece;
            }
        }
        throw new IllegalStateException("There is no " + color + " king on the board! Train Again.");
    }

    private boolean testCheck(Color color) {
        Position kingPosition = king(color).getChessPosition().toPosition();
        List<Piece> opponentPieces = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor() == opponent(color)).toList();
        for (Piece piece : opponentPieces) {
            boolean[][] mat = piece.possibleMoves();
            if (mat[kingPosition.getRow()][kingPosition.getColumn()]) {
                return true;
            }
        }
        return false;
    }

    private boolean testCheckMate(Color color) {
        if (!testCheck(color)) {
            return false;
        }
        List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor() == color).toList();
        for (Piece piece : list) {
            boolean[][] mat = piece.possibleMoves();
            for (int i=0; i<board.getRows(); i++) {
                for (int j=0; j<board.getColumns(); j++) {
                    if (mat[i][j]) {
                        Position source = ((ChessPiece)piece).getChessPosition().toPosition();
                        Position target = new Position(i, j);
                        Piece capturedPiece = makeMove(source, target);
                        boolean testCheck = testCheck(color);
                        undoMove(source, target, capturedPiece);
                        if (!testCheck) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
        piecesOnTheBoard.add(piece);
    }

    private void initialSetup() {
        placeNewPiece('a', 1, new Rook(board, Color.RED));
        placeNewPiece('b', 1, new Knight(board, Color.RED));
        placeNewPiece('c', 1, new Bishop(board, Color.RED));
        placeNewPiece('d', 1, new Queen(board, Color.RED));
        placeNewPiece('e', 1, new King(board, Color.RED, this));
        placeNewPiece('f', 1, new Bishop(board, Color.RED));
        placeNewPiece('g', 1, new Knight(board, Color.RED));
        placeNewPiece('h', 1, new Rook(board, Color.RED));
        placeNewPiece('a', 2, new Pawn(board, Color.RED, this));
        placeNewPiece('b', 2, new Pawn(board, Color.RED, this));
        placeNewPiece('c', 2, new Pawn(board, Color.RED, this));
        placeNewPiece('d', 2, new Pawn(board, Color.RED, this));
        placeNewPiece('e', 2, new Pawn(board, Color.RED, this));
        placeNewPiece('f', 2, new Pawn(board, Color.RED, this));
        placeNewPiece('g', 2, new Pawn(board, Color.RED, this));
        placeNewPiece('h', 2, new Pawn(board, Color.RED, this));

        placeNewPiece('a', 8, new Rook(board, Color.BLUE));
        placeNewPiece('b', 8, new Knight(board, Color.BLUE));
        placeNewPiece('c', 8, new Bishop(board, Color.BLUE));
        placeNewPiece('d', 8, new Queen(board, Color.BLUE));
        placeNewPiece('e', 8, new King(board, Color.BLUE, this));
        placeNewPiece('f', 8, new Bishop(board, Color.BLUE));
        placeNewPiece('g', 8, new Knight(board, Color.BLUE));
        placeNewPiece('h', 8, new Rook(board, Color.BLUE));
        placeNewPiece('a', 7, new Pawn(board, Color.BLUE, this));
        placeNewPiece('b', 7, new Pawn(board, Color.BLUE, this));
        placeNewPiece('c', 7, new Pawn(board, Color.BLUE, this));
        placeNewPiece('d', 7, new Pawn(board, Color.BLUE, this));
        placeNewPiece('e', 7, new Pawn(board, Color.BLUE, this));
        placeNewPiece('f', 7, new Pawn(board, Color.BLUE, this));
        placeNewPiece('g', 7, new Pawn(board, Color.BLUE, this));
        placeNewPiece('h', 7, new Pawn(board, Color.BLUE, this));
    }
}