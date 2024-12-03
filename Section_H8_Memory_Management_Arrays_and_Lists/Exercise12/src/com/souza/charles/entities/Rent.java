package com.souza.charles.entities;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Exercise done by: Charles Fernandes de Souza
 Date: November 16, 2024
 */
public class Rent {
    private String name;
    private String email;
    private int room;

    public Rent() {
    }

    public Rent(String name, String email, int room) {
        this.name = name;
        this.email = email;
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }
   // Bubble Sort O(n²)
    public static void sortRentsByRoom(Rent[] rents) {
        for (int i = 0; i < rents.length - 1; i++) {
            for (int j = 0; j < rents.length - i - 1; j++) {
                if (rents[j].getRoom() > rents[j + 1].getRoom()) {
                    Rent temp = rents[j];
                    rents[j] = rents[j + 1];
                    rents[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%d: %s, %s", room, name, email);
    }
}
