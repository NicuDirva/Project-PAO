package service;


import model.Driver;
import model.enums.DriverLicence;

import java.util.List;
import java.util.Optional;

public interface DriverService {
    public Optional<Driver> getById(Integer Id);

    List<Driver> getAll();

    void addOnlyOne(Driver driver);

    void removeById(Integer id);

    void modifyById(Integer id, Driver newdriver);

    void changePhoneNumber(Integer Id, String newPhoneNumber);
    void changeMail(Integer Id, String newMail);
    void addDriverLicence(Integer Id, DriverLicence newLicence);
}
