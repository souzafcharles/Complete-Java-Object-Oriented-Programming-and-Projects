package com.souza.charles.entities;

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
