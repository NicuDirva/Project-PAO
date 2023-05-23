package mapper;

import model.Car;
import model.enums.Color;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CarMapper {

    private static final CarMapper INSTANCE = new CarMapper();

    private CarMapper() {
    }

    public static CarMapper getInstance() {
        return INSTANCE;
    }

    public Optional<Car> mapToCar(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Car.builder()
                            .CarId(resultSet.getInt(1))
                            .DriverId(resultSet.getInt(2))
                            .Brand(resultSet.getString(3))
                            .Model(resultSet.getString(4))
                            .IdentificationNumber(resultSet.getString(5))
                            .Color(Color.valueOf(resultSet.getString(6)))
                            .NumberOfSeats(resultSet.getInt(7))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Car> mapToCarList(ResultSet resultSet) throws SQLException {
        List<Car> CarList = new ArrayList<>();
        while (resultSet.next()) {
            CarList.add(
                    Car.builder()
                            .CarId(resultSet.getInt(1))
                            .DriverId(resultSet.getInt(2))
                            .Brand(resultSet.getString(3))
                            .Model(resultSet.getString(4))
                            .IdentificationNumber(resultSet.getString(5))
                            .Color(Color.valueOf(resultSet.getString(6)))
                            .NumberOfSeats(resultSet.getInt(7))
                            .build()
            );
        }

        return CarList;
    }
}
