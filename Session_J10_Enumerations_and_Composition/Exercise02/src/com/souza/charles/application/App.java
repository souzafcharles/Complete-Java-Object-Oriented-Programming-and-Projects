package com.souza.charles.application;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Exercise done by: Charles Fernandes de Souza
 Date: November 21, 2024
 */
import com.souza.charles.entities.Comment;
import com.souza.charles.entities.Post;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        Comment comment01 = new Comment("Have a nice trip!");
        Comment comment02 = new Comment("Wow that's awesome!");
        Post post01 = new Post(
                LocalDateTime.parse("21/06/2018 13:05:44", dateTimeFormatter),
                "Traveling to New Zealand",
                "I'm going to visit this wonderful country!",
                12);
        post01.addComment(comment01);
        post01.addComment(comment02);

        Comment comment03 = new Comment("Good night");
        Comment comment04 = new Comment("May the Force be with you");
        Post post02 = new Post(
                LocalDateTime.parse("28/07/2018 23:14:19", dateTimeFormatter),
                "Good night guys",
                "See you tomorrow",
                5);
        post02.addComment(comment03);
        post02.addComment(comment04);

        System.out.println(post01);
        System.out.println(post02);
        scanner.close();
    }
}