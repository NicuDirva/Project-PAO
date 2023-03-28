package service.impl;

import model.PremiumPackage;
import service.PremiumPackageService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PremiumPackageServiceImpl implements PremiumPackageService {
    private static List<PremiumPackage> PremiumPackageList = new ArrayList<>();
    @Override
    public Optional<PremiumPackage> getById(Integer Id) {

        return PremiumPackageList.stream()
                .filter(object -> Id.equals(object.getPackageId()))
                .findFirst();
    }
    @Override
    public List<PremiumPackage> getAll() {
        return PremiumPackageList;
    };


    @Override
    public void addOnlyOne(PremiumPackage premiumPackage) {
        PremiumPackageList.add(premiumPackage);
    }

    @Override
    public void removeById(Integer Id) {
        PremiumPackageList = PremiumPackageList.stream()
                .filter(object -> !Id.equals(object.getPackageId()))
                .collect(Collectors.toList());
    }

    @Override
    public void modifyById(Integer Id, PremiumPackage newPremiumPackage) {

        removeById(Id);
        addOnlyOne(newPremiumPackage);

    }

    @Override
    public void changePricePackage(Integer Id, Double newPrice) {
        for (PremiumPackage premiumPackage : PremiumPackageList) {
            if(premiumPackage.getPackageId() == Id) {
                premiumPackage.setPrice(newPrice);
            }
        }
    }
}
