package service.impl;

import model.Location;
import model.Order;
import service.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {
    private static List<Order> OrderList = new ArrayList<>();
    @Override
    public Optional<Order> getById(Integer Id) {

        return OrderList.stream()
                .filter(object -> Id.equals(object.getOrderId()))
                .findFirst();
    }
    @Override
    public List<Order> getAll() {
        return OrderList;
    };


    @Override
    public void addOnlyOne(Order order) {
        OrderList.add(order);
    }

    @Override
    public void removeById(Integer Id) {
        OrderList = OrderList.stream()
                .filter(object -> !Id.equals(object.getOrderId()))
                .collect(Collectors.toList());
    }

    @Override
    public void modifyById(Integer Id, Order newOrder) {

        removeById(Id);
        addOnlyOne(newOrder);

    }
    @Override
    public void orderCancelated(Integer Id)
    {
        for (Order order : OrderList) {
            if (order.getOrderId() == Id) {
                order.setCanceled(true);
            }
        }
    }

    @Override
    public void changeOrderLocation(Integer Id, Location newLocation) {
        for (Order order : OrderList) {
            if (order.getOrderId() == Id) {
                order.setLocationId(newLocation.getLocationId());
            }
        }
    }

    @Override
    public void orderDelay(Integer Id, String newOrderReceiving) {
        for (Order order : OrderList) {
            if (order.getOrderId() == Id) {
                order.setReceivingTime(newOrderReceiving);
            }
        }
    }
}
