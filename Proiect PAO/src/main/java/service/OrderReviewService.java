package service;

import model.Location;
import model.OrderReview;

import java.util.List;
import java.util.Optional;

public interface OrderReviewService {
    public Optional<OrderReview> getById(Integer Id);

    List<OrderReview> getAll();

    void addOnlyOne(OrderReview orderReview);

    void removeById(Integer id);

    void modifyById(Integer id, OrderReview newOrderReview);
}
