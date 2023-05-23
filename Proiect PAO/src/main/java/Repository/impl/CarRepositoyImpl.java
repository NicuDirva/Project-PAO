package Repository.impl;

import Config.DatabaseConfiguration;
import Repository.CarRepository;
import mapper.CarMapper;
import model.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CarRepositoyImpl implements CarRepository {

    private static final CarMapper carMapper = mapper.CarMapper.getInstance();
    @Override
    public Optional<Car> getObjectById(Integer id) {
        String selectSql = "SELECT * FROM Car WHERE CarId=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setObject(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return carMapper.mapToCar(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override

    public void deleteObjectById(Integer id) {
        String updateCarSql = "DELETE FROM Car WHERE CarId=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(updateCarSql);
            preparedStatement.setObject(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObjectById(Integer id, Car newObject) {
        String updateCarSql = "UPDATE Car \n" +
                "SET CarId=?, \n" +
                "DriverId=?, \n" +
                "Brand=?, \n" +
                "Model=?, \n" +
                "IdentificationNumber=?, \n" +
                "Color=?, \n" +
                "NumberOfSeats=? \n" +
                "WHERE CarId=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(updateCarSql);
            preparedStatement.setInt(1, newObject.getCarId());
            preparedStatement.setInt(2, newObject.getDriverId());
            preparedStatement.setString(3, newObject.getBrand());
            preparedStatement.setString(4, newObject.getModel());
            preparedStatement.setString(5, newObject.getIdentificationNumber());
            preparedStatement.setString(6, newObject.getColor().toString());
            preparedStatement.setInt(7, newObject.getNumberOfSeats());
            preparedStatement.setObject(8, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewObject(Car car) {
        String insertSql = "INSERT INTO Car (CarId, DriverId, Brand, Model, IdentificationNumber, Color, NumberOfSeats) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setObject(1, car.getCarId());
            preparedStatement.setInt(2, car.getDriverId());
            preparedStatement.setString(3, car.getBrand());
            preparedStatement.setString(4, car.getModel());
            preparedStatement.setString(5, car.getIdentificationNumber());
            preparedStatement.setString(6, car.getColor().toString());
            preparedStatement.setInt(7, car.getNumberOfSeats());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Car> getAll() {
        String selectSql = "SELECT * FROM Car";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            ResultSet resultSet = preparedStatement.executeQuery();
            return carMapper.mapToCarList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Car> carsList) {
        carsList.forEach(this::addNewObject);
    }
}
