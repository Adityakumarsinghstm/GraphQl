package com.yt.graphql.services;

import com.yt.graphql.entities.Order;
import com.yt.graphql.helper.ExceptionHelper;
import com.yt.graphql.repositories.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    //create order
   public Order createOrder(Order order)
   {
       return  orderRepo.save(order);
   }

   //getall order
    public List<Order> getAllOrder()
    {
        return orderRepo.findAll();
    }

    //get single order
    public Order getOrder(int orderId)
    {
       Order order =  orderRepo.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
       return order;
    }
    //delete order
    public boolean deleteOrder(int orderId) {
        Order order =  orderRepo.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        orderRepo.delete(order);
        return true;
    }
}
