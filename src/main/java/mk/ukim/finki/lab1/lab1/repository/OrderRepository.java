package mk.ukim.finki.lab1.lab1.repository;

import mk.ukim.finki.lab1.lab1.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {

    public List<Order> orders;

    public OrderRepository() {
        this.orders = new ArrayList<>();
    }

    public Order addOrder(Order r){
        orders.add(r);
        return r;
    }

    public Optional<Order> findOrderByClientNameAndAddressAndSetSize(String name, String address,String size){
        Optional<Order> order = this.orders.stream()
                .filter(o -> o.getClientName().equals(name) &&
                        o.getClientAddress().equals(address)).findFirst();
        order.ifPresent(value -> value.setBalloonSize(size));
        return order;
    }
}
