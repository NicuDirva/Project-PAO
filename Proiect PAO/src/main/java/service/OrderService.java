package service;

import model.Location;
import model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    public Optional<Order> getById(Integer Id);

    List<Order> getAll();

    void addOnlyOne(Order order);

    void removeById(Integer id);

    void modifyById(Integer id, Order newOrder);

    void orderCancelated(Integer id);

    void changeOrderLocation(Integer id, Location newLocation);
    void orderDelay(Integer Id, String newOrderReceiving);
}
