package mk.ukim.finki.lab1.lab1.service.impl;

import mk.ukim.finki.lab1.lab1.model.Order;
import mk.ukim.finki.lab1.lab1.model.exceptions.InvalidArgumentsException;
import mk.ukim.finki.lab1.lab1.repository.OrderRepository;
import mk.ukim.finki.lab1.lab1.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order placeOrder(String balloonColor, String clientName, String address) {
        if(clientName == null || clientName.isEmpty() || address == null || address.isEmpty())
            throw new InvalidArgumentsException();
        return this.orderRepository.addOrder(new Order(balloonColor,clientName,address));
    }

    @Override
    public Order findOrderByClientAndAddressAndSetSize(String name, String address, String size) {
        return this.orderRepository.findOrderByClientNameAndAddressAndSetSize(name,address,size).get();
    }


}
