package com.hateoas.hateoasdemo.service;

import com.hateoas.hateoasdemo.doamin.Order;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public List<Order> getAllOrdersByCustomer(String customerId) {
        List<Order> orders = new ArrayList<>();
        if (customerId.equals("1")) {
            orders.add(new Order("1", 1.0, 10));
            orders.add(new Order("2", 2.0, 20));
            orders.add(new Order("3", 3.0, 30));
        }
        return orders;
    }
}
