package com.souza.charles.application;
/*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: February 13, 2025
*/

import com.souza.charles.chessgame.ChessMatch;
import com.souza.charles.chessgame.ChessPiece;
import com.souza.charles.chessgame.ChessPosition;
import com.souza.charles.chessgame.Color;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;


import java.util.Scanner;

public class UI {

    // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    // https://stackoverflow.com/questions/2979383/java-clear-the-console
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static ChessPosition readChessPosition(Scanner scanner) {
        try {
            String s = scanner.nextLine();
            char column = s.charAt(0);
            int row = Integer.parseInt(s.substring(1));
            return new ChessPosition(column, row);
        }
        catch (RuntimeException e) {
            throw new InputMismatchException("Error reading ChessPosition. Valid values are from a1 to h8! Train Again.");
        }
    }

    public static void printMatch(ChessMatch chessMatch, List<ChessPiece> captured) {
        printBoard(chessMatch.getPieces());
        System.out.println();
        printCapturedPieces(captured);
        System.out.println();
        System.out.println("Turn : " + chessMatch.getTurn());
        if (!chessMatch.getCheckMate()) {
            System.out.println("Waiting player: " + chessMatch.getCurrentPlayer());
            if (chessMatch.getCheck()) {
                System.out.println("CHECK!");
            }
        }
        else {
            System.out.println("CHECKMATE!");
            System.out.println("Winner \uD83C\uDFC6: " + chessMatch.getCurrentPlayer());
        }
    }

    public static void printBoard(ChessPiece[][] pieces) {
        for (int i = 0; i < pieces.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < pieces.length; j++) {
                printPiece(pieces[i][j], i, j);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
        for (int i = 0; i < pieces.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < pieces.length; j++) {
                if (possibleMoves[i][j]) {
                    System.out.print(ANSI_BLUE_BACKGROUND);
                }
                printPiece(pieces[i][j], i, j);
                System.out.print(ANSI_RESET);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    private static void printPiece(ChessPiece piece, int row, int col) {
        if (piece == null) {
            if ((row + col) % 2 == 0) {
                System.out.print("▫ ");
            } else {
                System.out.print("▪ ");
            }
        } else {
            if (piece.getColor() == Color.RED) {
                System.out.print(ANSI_RED + piece + ANSI_RESET + " ");
            } else {
                System.out.print(ANSI_BLUE + piece + ANSI_RESET + " ");
            }
        }
    }


    private static void printCapturedPieces(List<ChessPiece> captured) {
        List<ChessPiece> red = captured.stream().filter(x -> x.getColor() == Color.RED).toList();
        List<ChessPiece> blue = captured.stream().filter(x -> x.getColor() == Color.BLUE).toList();
        System.out.println("Captured pieces:");
        System.out.print("Red: ");
        System.out.print(ANSI_RED);
        System.out.println(Arrays.toString(red.toArray()));
        System.out.print(ANSI_RESET);
        System.out.print("Blue: ");
        System.out.print(ANSI_BLUE);
        System.out.println(Arrays.toString(blue.toArray()));
        System.out.print(ANSI_RESET);
    }
}