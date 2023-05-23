package Repository.impl;

import Config.DatabaseConfiguration;
import Repository.LocationRepository;
import mapper.LocationMapper;
import mapper.PersonMapper;
import model.Location;
import model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class LocationRepositoryImpl implements LocationRepository {

    private static final LocationMapper locationMapper = mapper.LocationMapper.getInstance();
    @Override
    public Optional<Location> getObjectById(Integer id) {
        String selectSql = "SELECT * FROM Location WHERE LocationId=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setObject(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return locationMapper.mapToLocation(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override

    public void deleteObjectById(Integer id) {
        String updateCarSql = "DELETE FROM Location WHERE LocationId=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(updateCarSql);
            preparedStatement.setObject(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObjectById(Integer id, Location newObject) {
        String updateCarSql = "UPDATE Location \n" +
                "SET LocationId=?, \n" +
                "City=?, \n" +
                "Street=?, \n" +
                "Number=? \n" +
                "WHERE LocationId=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(updateCarSql);
            preparedStatement.setInt(1, newObject.getLocationId());
            preparedStatement.setString(2, newObject.getCity());
            preparedStatement.setString(3, newObject.getStreet());
            preparedStatement.setInt(4, newObject.getNumber());
            preparedStatement.setObject(5, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewObject(Location location) {
        String insertSql = "INSERT INTO Location (LocationId, City, Street, Number) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setObject(1, location.getLocationId());
            preparedStatement.setString(2, location.getCity());
            preparedStatement.setString(3, location.getStreet());
            preparedStatement.setInt(4, location.getNumber());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Location> getAll() {
        String selectSql = "SELECT * FROM Location";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            ResultSet resultSet = preparedStatement.executeQuery();
            return locationMapper.mapToLocationList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Location> locationList) {
        locationList.forEach(this::addNewObject);
    }
}
