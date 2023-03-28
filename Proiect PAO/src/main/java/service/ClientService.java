package service;

import model.Client;
import java.util.List;
import java.util.Optional;


public interface ClientService{
    public Optional<Client> getById(Integer Id);

    List<Client> getAll();


    void addOnlyOne(Client client);

    void removeById(Integer id);

    void modifyById(Integer id, Client newclient);

    void changePhoneNumber(Integer Id, String newPhoneNumber);
    void changeMail(Integer Id, String newMail);
}
