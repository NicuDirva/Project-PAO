package mapper;

import model.Car;
import model.Company;
import model.Driver;
import model.Person;
import model.enums.Color;
import model.enums.DrivingLicenceCategories;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CompanyMapper {
    private static final CompanyMapper INSTANCE = new CompanyMapper();

    private CompanyMapper() {
    }

    public static CompanyMapper getInstance() {
        return INSTANCE;
    }

    public Person mapToOwner(ResultSet resultSet) throws SQLException {
        return Person.builder()
                .PersonId(resultSet.getInt(1))
                .FirstName(resultSet.getString(2))
                .LastName(resultSet.getString(3))
                .DateOfBird(resultSet.getString(4))
                .Gender(resultSet.getString(5))
                .build();
    }
    public Driver mapToDriver(ResultSet resultSet) throws SQLException {
        Set<DrivingLicenceCategories> drivingLicenceCategoriesSet = new HashSet<>();
        Array drivingLicenceCategoriesArray = resultSet.getArray(6);
        Object[] objectArray = (Object[]) drivingLicenceCategoriesArray.getArray();

        for (Object obj : objectArray) {
            if (obj instanceof DrivingLicenceCategories) {
                drivingLicenceCategoriesSet.add((DrivingLicenceCategories) obj);
            }
        }
        return Driver.builder()
                .DriverId(resultSet.getInt(1))
                .PersonId(resultSet.getInt(2))
                .PhoneNumber(resultSet.getString(3))
                .Mail(resultSet.getString(4))
                .DriverLicenceDate(resultSet.getString(5))
                .DrivingLicenceCategories(drivingLicenceCategoriesSet)
                .build();
    }

    public Optional<Company> mapToCompany(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            Person owner = mapToOwner(resultSet);
            List<Driver> driversList = new ArrayList<>();
            Integer EmployeesNumber = resultSet.getInt(5);
            for (int i = 0; i < EmployeesNumber; i++) {
                Driver driver = mapToDriver(resultSet);
                driversList.add(driver);
            }
            return Optional.of(
                    Company.builder()
                            .CompanyId(resultSet.getInt(1))
                            .Name(resultSet.getString(2))
                            .FoundationDate(resultSet.getString(3))
                            .Owner(owner)
                            .EmployeesNumber(EmployeesNumber)
                            .DriverList(driversList)
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Company> mapToCompanyList(ResultSet resultSet) throws SQLException {
        List<Company> CompanyList = new ArrayList<>();
        while (resultSet.next()) {
            Person owner = mapToOwner(resultSet);
            List<Driver> driversList = new ArrayList<>();
            Integer EmployeesNumber = resultSet.getInt(5);
            for (int i = 0; i < EmployeesNumber; i++) {
                Driver driver = mapToDriver(resultSet);
                driversList.add(driver);
            }
            CompanyList.add(
                    Company.builder()
                            .CompanyId(resultSet.getInt(1))
                            .Name(resultSet.getString(2))
                            .FoundationDate(resultSet.getString(3))
                            .Owner(owner)
                            .EmployeesNumber(EmployeesNumber)
                            .DriverList(driversList)
                            .build()
            );
        }

        return CompanyList;
    }
}
