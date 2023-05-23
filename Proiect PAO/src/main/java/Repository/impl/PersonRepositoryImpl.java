package Repository.impl;

import Config.DatabaseConfiguration;
import Repository.PersonRepository;
import mapper.CarMapper;
import mapper.PersonMapper;
import model.Car;
import model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PersonRepositoryImpl  implements PersonRepository {

    private static final PersonMapper personMapper = mapper.PersonMapper.getInstance();
    @Override
    public Optional<Person> getObjectById(Integer id) {
        String selectSql = "SELECT * FROM Person WHERE PersonId=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setObject(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return personMapper.mapToPerson(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override

    public void deleteObjectById(Integer id) {
        String updateCarSql = "DELETE FROM Person WHERE PersonId=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(updateCarSql);
            preparedStatement.setObject(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObjectById(Integer id, Person newObject) {
        String updateCarSql = "UPDATE Person \n" +
                "SET PersonId=?, \n" +
                "FirstName=?, \n" +
                "LastName=?, \n" +
                "DateOfBird=?, \n" +
                "Gender=? \n" +
                "WHERE PersonId=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(updateCarSql);
            preparedStatement.setInt(1, newObject.getPersonId());
            preparedStatement.setString(2, newObject.getFirstName());
            preparedStatement.setString(3, newObject.getLastName());
            preparedStatement.setString(4, newObject.getDateOfBird());
            preparedStatement.setString(5, newObject.getGender());
            preparedStatement.setObject(6, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewObject(Person person) {
        String insertSql = "INSERT INTO Person (PersonId, FirstName, LastName, DateOfBird, Gender) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setObject(1, person.getPersonId());
            preparedStatement.setString(2, person.getFirstName());
            preparedStatement.setString(3, person.getLastName());
            preparedStatement.setString(4, person.getDateOfBird());
            preparedStatement.setString(5, person.getGender());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Person> getAll() {
        String selectSql = "SELECT * FROM Person";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            ResultSet resultSet = preparedStatement.executeQuery();
            return personMapper.mapToPersonList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Person> personList) {
        personList.forEach(this::addNewObject);
    }
}
