package com.hateoas.hateoasdemo.doamin;

import org.springframework.hateoas.EntityModel;

public class Order extends EntityModel<Order> {

    private String orderId;

    private Double price;

    private Integer quantity;

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
