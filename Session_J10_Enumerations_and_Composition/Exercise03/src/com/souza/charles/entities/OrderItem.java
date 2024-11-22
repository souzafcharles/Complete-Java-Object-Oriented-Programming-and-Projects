package com.souza.charles.entities;

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
        return quantityOrderItem * product.getPriceProduct();
    }
}
