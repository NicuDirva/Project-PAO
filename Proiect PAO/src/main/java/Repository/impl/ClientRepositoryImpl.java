package Repository.impl;

import Config.DatabaseConfiguration;
import Repository.ClientRepository;
import mapper.ClientMapper;
import mapper.LocationMapper;
import mapper.PersonMapper;
import model.Client;
import model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ClientRepositoryImpl implements ClientRepository {
    private static final ClientMapper clientMapper = mapper.ClientMapper.getInstance();
    @Override
    public Optional<Client> getObjectById(Integer id) {
        String selectSql = "SELECT * FROM Client WHERE ClientId=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setObject(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return clientMapper.mapToClient(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override

    public void deleteObjectById(Integer id) {
        String updateCarSql = "DELETE FROM Client WHERE PersonId=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(updateCarSql);
            preparedStatement.setObject(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObjectById(Integer id, Client newObject) {
        String updateCarSql = "UPDATE Client \n" +
                "SET ClientId=?, \n" +
                "PersonId=?, \n" +
                "PhoneNumber=?, \n" +
                "Mail=? \n" +
                "WHERE ClientId=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(updateCarSql);
            preparedStatement.setInt(1, newObject.getClientId());
            preparedStatement.setInt(2, newObject.getPersonId());
            preparedStatement.setString(3, newObject.getPhoneNumber());
            preparedStatement.setString(4, newObject.getMail());
            preparedStatement.setObject(5, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewObject(Client client) {
        String insertSql = "INSERT INTO Client (ClientId, PersonId, PhoneNumber, Mail) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setObject(1, client.getClientId());
            preparedStatement.setInt(2, client.getPersonId());
            preparedStatement.setString(3, client.getPhoneNumber());
            preparedStatement.setString(4, client.getMail());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Client> getAll() {
        String selectSql = "SELECT * FROM Client";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            ResultSet resultSet = preparedStatement.executeQuery();
            return clientMapper.mapToClientList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Client> clientList) {
        clientList.forEach(this::addNewObject);
    }
}
