package service.impl;

import model.Company;
import model.DiscountCoupon;
import service.DiscountCouponService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DiscountCouponServiceImpl implements DiscountCouponService {
    private static List<DiscountCoupon> DiscountCouponList = new ArrayList<>();
    @Override
    public Optional<DiscountCoupon> getById(Integer Id) {

        return DiscountCouponList.stream()
                .filter(object -> Id.equals(object.getCouponId()))
                .findFirst();
    }
    @Override
    public List<DiscountCoupon> getAll() {
        return DiscountCouponList;
    };


    @Override
    public void addOnlyOne(DiscountCoupon discountCoupon) {
        DiscountCouponList.add(discountCoupon);
    }

    @Override
    public void removeById(Integer Id) {
        DiscountCouponList = DiscountCouponList.stream()
                .filter(object -> !Id.equals(object.getCouponId()))
                .collect(Collectors.toList());
    }

    @Override
    public void modifyById(Integer Id, DiscountCoupon newdiscountCoupon) {

        removeById(Id);
        addOnlyOne(newdiscountCoupon);

    }
}
