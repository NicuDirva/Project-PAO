package service;

import model.DiscountCoupon;

import java.util.List;
import java.util.Optional;

public interface DiscountCouponService {
    public Optional<DiscountCoupon> getById(Integer Id);

    List<DiscountCoupon> getAll();

    void addOnlyOne(DiscountCoupon discountCoupon);

    void removeById(Integer id);

    void modifyById(Integer id, DiscountCoupon newdiscountcoupon);
}
