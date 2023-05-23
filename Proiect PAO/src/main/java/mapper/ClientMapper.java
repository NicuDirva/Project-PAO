package mapper;

import model.Car;
import model.Client;
import model.enums.Color;
import service.ClientService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientMapper {
    private static final ClientMapper INSTANCE = new ClientMapper();

    private ClientMapper() {
    }

    public static ClientMapper getInstance() {
        return INSTANCE;
    }

    public Optional<Client> mapToClient(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Client.builder()
                            .ClientId(resultSet.getInt(1))
                            .PersonId(resultSet.getInt(2))
                            .PhoneNumber(resultSet.getString(3))
                            .Mail(resultSet.getString(4))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Client> mapToClientList(ResultSet resultSet) throws SQLException {
        List<Client> ClientList = new ArrayList<>();
        while (resultSet.next()) {
            ClientList.add(
                    Client.builder()
                            .ClientId(resultSet.getInt(1))
                            .PersonId(resultSet.getInt(2))
                            .PhoneNumber(resultSet.getString(3))
                            .Mail(resultSet.getString(4))
                            .build()
            );
        }

        return ClientList;
    }
}
