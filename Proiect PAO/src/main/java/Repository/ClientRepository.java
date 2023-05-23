package Repository;

import model.Car;
import model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    Optional<Client> getObjectById(Integer id);

    void deleteObjectById(Integer id);

    void updateObjectById(Integer id, Client newObject);

    void addNewObject(Client client);

    List<Client> getAll();

    void addAllFromGivenList(List<Client> clientList);
}
