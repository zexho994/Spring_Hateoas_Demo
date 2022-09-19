package com.hateoas.hateoasdemo.api;

import com.hateoas.hateoasdemo.doamin.Customer;
import com.hateoas.hateoasdemo.service.CustomerService;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable String customerId) {
        Customer customer = customerService.getCustomerDetail(customerId);
        Link link = WebMvcLinkBuilder.linkTo(CustomerController.class)
                .slash(customer.getCustomerId())
                .withRel("self");
        customer.add(link);
        return customer;
    }

}
