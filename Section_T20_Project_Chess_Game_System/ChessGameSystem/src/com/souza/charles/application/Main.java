package com.souza.charles.application;
/*
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Project done by: Charles Fernandes de Souza
 Date: February 12, 2025
*/

import com.souza.charles.boardgame.Position;

public class Main {

    public static void main(String[] args) {
        System.out.println("Project: ♟\uFE0F Chess Game System ♟\uFE0F");

        Position position = new Position(3, 5);
        System.out.println(position);
    }
}