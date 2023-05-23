package mapper;

import model.Car;
import model.Driver;
import model.Location;
import model.enums.Color;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LocationMapper {
    private static final LocationMapper INSTANCE = new LocationMapper();

    private LocationMapper() {
    }

    public static LocationMapper getInstance() {
        return INSTANCE;
    }

    public Optional<Location> mapToLocation(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Location.builder()
                            .LocationId(resultSet.getInt(1))
                            .City(resultSet.getString(2))
                            .Street(resultSet.getString(3))
                            .Number(resultSet.getInt(4))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Location> mapToLocationList(ResultSet resultSet) throws SQLException {
        List<Location> LocationList = new ArrayList<>();
        while (resultSet.next()) {
            LocationList.add(
                    Location.builder()
                            .LocationId(resultSet.getInt(1))
                            .City(resultSet.getString(2))
                            .Street(resultSet.getString(3))
                            .Number(resultSet.getInt(4))
                            .build()
            );
        }

        return LocationList;
    }
}
