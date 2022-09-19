package com.hateoas.hateoasdemo.api;

import com.hateoas.hateoasdemo.doamin.Customer;
import com.hateoas.hateoasdemo.doamin.Order;
import com.hateoas.hateoasdemo.service.CustomerService;
import com.hateoas.hateoasdemo.service.OrderService;
import java.util.List;
import org.springframework.hateoas.CollectionModel;
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
    private final OrderService orderService;

    public CustomerController(CustomerService customerService, OrderService orderService) {
        this.customerService = customerService;
        this.orderService = orderService;
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

    @GetMapping("/{customerId}/order/{orderId}")
    public Order getOrderById(@PathVariable final String customerId, @PathVariable final String orderId) {
        return null;
    }

    @GetMapping("/{customerId}/orders")
    public CollectionModel<Order> getOrdersByCustomer(@PathVariable final String customerId) {
        List<Order> orders = orderService.getAllOrdersByCustomer(customerId);
        for (Order o : orders) {
            Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerController.class)
                    .getOrderById(customerId, o.getOrderId())).withRel("self");
            o.add(link);
        }

        Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerController.class)
                .getOrdersByCustomer(customerId)).withRel("self");
        return CollectionModel.of(orders, link);
    }

}
