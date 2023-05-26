package service.impl;

import model.Company;
import model.Driver;
import model.Person;
import service.CompanyService;

import java.util.*;
import java.util.stream.Collectors;

public class CompanyServiceImpl implements CompanyService {
    private static List<Company> CompanyList = new ArrayList<>();

    @Override
    public Optional<Company> getById(Integer Id) {

        return CompanyList.stream()
                .filter(object -> Id.equals(object.getCompanyId()))
                .findFirst();
    }

    @Override
    public List<Company> getAll() {
        return CompanyList;
    }


    @Override
    public void addOnlyOne(Company company) {
        CompanyList.add(company);
    }

    @Override
    public void removeById(Integer Id) {
        CompanyList = CompanyList.stream()
                .filter(object -> !Id.equals(object.getCompanyId()))
                .collect(Collectors.toList());
    }

    @Override
    public void modifyById(Integer Id, Company newcompany) {

        removeById(Id);
        addOnlyOne(newcompany);

    }

    @Override
    public void addNewDriver(Integer Id, Driver newDriver) {
        for (Company company : CompanyList) {
            if (company.getCompanyId() == Id) {
                List<Driver> currentDriver = company.getDriverList();
                currentDriver.add(newDriver);
                company.setDriverList(currentDriver);
            }
        }
    }

    @Override
    public void changeEmployeesNumber(Integer Id, Integer newEmployeesNumber) {
        for (Company company : CompanyList) {
            if (company.getCompanyId() == Id) {
                company.setEmployeesNumber(newEmployeesNumber);
            }
        }
    }

    @Override
    public void changePresident(Integer Id, Person newPresident) {
        for (Company company : CompanyList) {
            if (company.getCompanyId() == Id) {
                company.setOwner(newPresident);
            }
        }
    }

    @Override
    public void changeCompanyName(Integer Id, String newName) {
        for (Company company : CompanyList) {
            if (company.getCompanyId() == Id) {
                company.setName(newName);
            }
        }
    }

    @Override
    public void sortDrivers(Integer Id) {
        /*for (Company company : CompanyList) {
            if (company.getCompanyId() == Id) {
                List<Driver> drivers = company.getDriverList();
                Collections.sort(drivers, Comparator.comparing(d -> d.getDrivingLicenceCategories().size()));
                Collections.reverse(drivers);
                company.setDriverList(drivers);
            }
        }*/
        Iterator<Company> iterator = CompanyList.iterator();
        while (iterator.hasNext()) {
            Company company = iterator.next();
            if (company.getCompanyId() == Id) {
                List<Driver> drivers = company.getDriverList();
                Collections.sort(drivers, Comparator.comparing(d -> d.getDrivingLicenceCategories().size()));
                Collections.reverse(drivers);
                company.setDriverList(drivers);
            }
        }
    }
}


