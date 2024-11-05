package com.souza.charles.entities;
/**
 * Course title: Complete Java - Object-Oriented Programming + Projects
 * Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 * Exercise done by: Charles Fernandes de Souza
 * Date: November 05, 2024
 */
public class Product {

    public String name;
    public double price;
    public int quantity;

    public Double totalValueInStock(){
        return price*quantity;
    }

    public void addProducts(int quantity){
        this.quantity += quantity;
    }

    public void removeProducts(int quantity){
        this.quantity -= quantity;
    }

    @Override
    public String toString() {
        return String.format(" %s, $ %.2f, %d units, Total: $ %.2f", name, price, quantity, totalValueInStock());
    }
}
