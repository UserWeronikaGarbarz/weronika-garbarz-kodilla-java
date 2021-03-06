package com.kodilla.good.patterns.food2door.order;

import com.kodilla.good.patterns.food2door.producer.Product;

public class Order {
    private final String orderNumber;
    private final Product product;
    private final Long quantity;

    public Order(String orderNumber, Product product, Long quantity) {
        this.orderNumber = orderNumber;
        this.product = product;
        this.quantity = quantity;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public Product getProduct() {
        return product;
    }

    public Long getQuantity() {
        return quantity;
    }
}
