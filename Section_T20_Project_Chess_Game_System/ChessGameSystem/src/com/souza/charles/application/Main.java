package com.souza.charles.application;
/*
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Project done by: Charles Fernandes de Souza
 Date: February 12, 2025
*/

import com.souza.charles.boardgame.Board;
import com.souza.charles.boardgame.Position;
import com.souza.charles.chessgame.ChessMatch;

public class Main {

    public static void main(String[] args) {

        System.out.println("♟\uFE0F Chess Game System ♟\uFE0F");
        ChessMatch chessMatch = new ChessMatch();
        UI.printBoard(chessMatch.getPieces());
    }
}