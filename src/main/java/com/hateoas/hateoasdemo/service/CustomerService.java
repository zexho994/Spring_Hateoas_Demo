package com.hateoas.hateoasdemo.service;

import com.hateoas.hateoasdemo.doamin.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public Customer getCustomerDetail(String customerId) {
        if ("1".equals(customerId)) {
            return new Customer(customerId, "name-1", "company-1");
        }
        return null;
    }
}
