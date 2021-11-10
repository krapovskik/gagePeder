package mk.ukim.finki.lab1.lab1.service;

import mk.ukim.finki.lab1.lab1.model.Order;

import java.util.Optional;

public interface OrderService{
    Order placeOrder(String balloonColor, String clientName, String address);
    Order findOrderByClientAndAddressAndSetSize(String name, String address,String size);
}