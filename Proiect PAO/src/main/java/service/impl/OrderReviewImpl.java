package service.impl;

import model.Location;
import model.OrderReview;
import service.OrderReviewService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderReviewImpl implements OrderReviewService {
    private static List<OrderReview> OrderReviewList = new ArrayList<>();
    @Override
    public Optional<OrderReview> getById(Integer Id) {

        return OrderReviewList.stream()
                .filter(object -> Id.equals(object.getOrderReviewId()))
                .findFirst();
    }
    @Override
    public List<OrderReview> getAll() {
        return OrderReviewList;
    };


    @Override
    public void addOnlyOne(OrderReview orderReview) {
        OrderReviewList.add(orderReview);
    }

    @Override
    public void removeById(Integer Id) {
        OrderReviewList = OrderReviewList.stream()
                .filter(object -> !Id.equals(object.getOrderReviewId()))
                .collect(Collectors.toList());
    }

    @Override
    public void modifyById(Integer Id, OrderReview newOrderReview) {

        removeById(Id);
        addOnlyOne(newOrderReview);

    }
}
