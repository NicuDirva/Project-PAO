package service;

import model.Company;
import model.Driver;
import model.Person;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    public Optional<Company> getById(Integer Id);

    List<Company> getAll();

    void addOnlyOne(Company company);

    void removeById(Integer id);

    void modifyById(Integer id, Company newcompany);

    void addNewDriver(Integer Id, Driver newDriver);

    void changeEmployeesNumber(Integer Id, Integer newEmployeesNumber);
    void changePresident(Integer Id, Person newPresident);

    void changeCompanyName(Integer Id, String newName);
    void sortDrivers(Integer Id);
}
