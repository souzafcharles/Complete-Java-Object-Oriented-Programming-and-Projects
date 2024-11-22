package com.souza.charles.model.entities;
/**
 Course title: Complete Java - Object-Oriented Programming + Projects
 Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
 Exercise done by: Charles Fernandes de Souza
 Date: November 22, 2024
 */
public class OrderItem {

    private Integer quantityOrderItem;
    private Double priceOrderItem;
    private Product product;

    public OrderItem() {
    }

    public OrderItem(Integer quantityOrderItem, Double priceOrderItem, Product product) {
        this.quantityOrderItem = quantityOrderItem;
        this.priceOrderItem = priceOrderItem;
        this.product = product;
    }

    public Integer getQuantityOrderItem() {
        return quantityOrderItem;
    }

    public void setQuantityOrderItem(Integer quantityOrderItem) {
        this.quantityOrderItem = quantityOrderItem;
    }

    public Double getPriceOrderItem() {
        return priceOrderItem;
    }

    public void setPriceOrderItem(Double priceOrderItem) {
        this.priceOrderItem = priceOrderItem;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double subTotal(){
        return priceOrderItem * quantityOrderItem;
    }

    @Override
    public String toString() {
        return String.format("%s, $%.2f, Quantity: %d, Subtotal: $%.2f", product.getNameProduct(), product.getPriceProduct(), quantityOrderItem, subTotal());
    }
}