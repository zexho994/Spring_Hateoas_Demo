package com.hateoas.hateoasdemo.doamin;

import org.springframework.hateoas.RepresentationModel;

public class Order extends RepresentationModel<Order> {

    private String orderId;

    private Double price;

    private Integer quantity;

    public Order(String orderId, Double price, Integer quantity) {
        this.orderId = orderId;
        this.price = price;
        this.quantity = quantity;
    }
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
