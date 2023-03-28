package service;

import model.Location;
import model.PremiumPackage;

import java.util.List;
import java.util.Optional;

public interface PremiumPackageService {

    public Optional<PremiumPackage> getById(Integer Id);

    List<PremiumPackage> getAll();

    void addOnlyOne(PremiumPackage premiumPackage);

    void removeById(Integer id);

    void modifyById(Integer id, PremiumPackage newPremiumPackage);
    void changePricePackage(Integer Id, Double newPrice);
}
