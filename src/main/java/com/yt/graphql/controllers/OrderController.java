package com.yt.graphql.controllers;

import com.yt.graphql.entities.Order;
import com.yt.graphql.entities.User;
import com.yt.graphql.repositories.OrderRepo;
import com.yt.graphql.repositories.UserRepo;
import com.yt.graphql.services.OrderService;
import com.yt.graphql.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;

    //Create orders
    @MutationMapping
    public Order createOrder(
            @Argument String orderDetails,
            @Argument String address,
            @Argument int price,
            @Argument int userId
    )
    {
        User user = userService.getUser(userId);
        Order order = new Order();
        order.setOrderDetails(orderDetails);
        order.setAddress(address);
        order.setPrice(price);
        order.setUser(user);
        Order order1 = orderService.createOrder(order);
        return order1;
    }

    //get Orders
    @QueryMapping
    public List<Order> getOrders()
    {
       return orderService.getAllOrder();
    }

    //get order
    @QueryMapping
    public Order getOrder(@Argument int orderId)
    {
       return orderService.getOrder(orderId);
    }

    //deleteOrder
    @MutationMapping
    public boolean deleteOrder(@Argument int orderId)
    {
       return orderService.deleteOrder(orderId);
    }

}
