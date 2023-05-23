package mapper;

import model.Car;
import model.Driver;
import model.enums.Color;
import model.enums.DrivingLicenceCategories;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DriverMapper {
    private static final DriverMapper INSTANCE = new DriverMapper();

    private DriverMapper() {
    }

    public static DriverMapper getInstance() {
        return INSTANCE;
    }

    public Optional<Driver> mapToDriver(ResultSet resultSet) throws SQLException {

        Set<DrivingLicenceCategories> drivingLicenceCategoriesSet = new HashSet<>();
        Array drivingLicenceCategoriesArray = resultSet.getArray(6);
        Object[] objectArray = (Object[]) drivingLicenceCategoriesArray.getArray();

        for (Object obj : objectArray) {
            if (obj instanceof DrivingLicenceCategories) {
                drivingLicenceCategoriesSet.add((DrivingLicenceCategories) obj);
            }
        }

        if (resultSet.next()) {
            return Optional.of(
                    Driver.builder()
                            .DriverId(resultSet.getInt(1))
                            .PersonId(resultSet.getInt(2))
                            .PhoneNumber(resultSet.getString(3))
                            .Mail(resultSet.getString(4))
                            .DriverLicenceDate(resultSet.getString(5))
                            .DrivingLicenceCategories(drivingLicenceCategoriesSet)
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Driver> mapToDriverList(ResultSet resultSet) throws SQLException {
        List<Driver> DriverList = new ArrayList<>();
        while (resultSet.next()) {
            Set<DrivingLicenceCategories> drivingLicenceCategoriesSet = new HashSet<>();
            Array drivingLicenceCategoriesArray = resultSet.getArray(6);
            Object[] objectArray = (Object[]) drivingLicenceCategoriesArray.getArray();

            for (Object obj : objectArray) {
                if (obj instanceof DrivingLicenceCategories) {
                    drivingLicenceCategoriesSet.add((DrivingLicenceCategories) obj);
                }
            }
            DriverList.add(
                    Driver.builder()
                            .DriverId(resultSet.getInt(1))
                            .PersonId(resultSet.getInt(2))
                            .PhoneNumber(resultSet.getString(3))
                            .Mail(resultSet.getString(4))
                            .DriverLicenceDate(resultSet.getString(5))
                            .DrivingLicenceCategories(drivingLicenceCategoriesSet)
                            .build()
            );
        }

        return DriverList;
    }
}
