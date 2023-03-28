package service.impl;


import model.Driver;
import model.enums.DrivingLicenceCategories;
import service.DriverService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class DriverServiceImpl implements DriverService {
    private static List<Driver> DriverList = new ArrayList<>();
    @Override
    public Optional<Driver> getById(Integer Id) {

        return DriverList.stream()
                .filter(object -> Id.equals(object.getDriverId()))
                .findFirst();
    }
    @Override
    public List<Driver> getAll() {
        return DriverList;
    };


    @Override
    public void addOnlyOne(Driver driver) {
        DriverList.add(driver);
    }

    @Override
    public void removeById(Integer Id) {
        DriverList = DriverList.stream()
                .filter(object -> !Id.equals(object.getDriverId()))
                .collect(Collectors.toList());
    }

    @Override
    public void modifyById(Integer Id, Driver newDriver) {

        removeById(Id);
        addOnlyOne(newDriver);

    }

    @Override
    public void changePhoneNumber(Integer Id, String newPhoneNumber) {
        for (Driver driver : DriverList) {
            if (driver.getDriverId() == Id) {
                driver.setPhoneNumber(newPhoneNumber);
            }
        }
    }

    @Override
    public void changeMail(Integer Id, String newMail) {
        for (Driver driver : DriverList) {
            if (driver.getDriverId() == Id) {
                driver.setMail(newMail);
            }
        }
    }

    @Override
    public void addDriverLicence(Integer Id, DrivingLicenceCategories newLicence) {
        for (Driver driver : DriverList) {
            if (driver.getDriverId() == Id) {
                Set<DrivingLicenceCategories> currentDrivingLicenceCategories =  driver.getDrivingLicenceCategories();
                currentDrivingLicenceCategories.add(newLicence);
                driver.setDrivingLicenceCategories(currentDrivingLicenceCategories);
            }
        }
    }

}
