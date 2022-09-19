package com.hateoas.hateoasdemo.service;

import com.hateoas.hateoasdemo.doamin.Customer;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    Customer customer1 = new Customer("1", "name-1", "company-1");

    public Customer getCustomerDetail(String customerId) {
        if ("1".equals(customerId)) {
            return customer1;
        }
        return null;
    }

    public List<Customer> getAll() {
        return Arrays.asList(customer1);
    }

}
