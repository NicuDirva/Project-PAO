package service.impl;

import model.Client;
import service.ClientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ClientServiceImpl implements ClientService {
    private static List<Client> ClientList = new ArrayList<>();
    @Override
    public Optional<Client> getById(Integer Id) {

        return ClientList.stream()
                .filter(object -> Id.equals(object.getClientId()))
                .findFirst();
    }
    @Override
    public List<Client> getAll() {
        return ClientList;
    };


    @Override
    public void addOnlyOne(Client client) {
        ClientList.add(client);
    }

    @Override
    public void removeById(Integer Id) {
        ClientList = ClientList.stream()
                .filter(object -> !Id.equals(object.getClientId()))
                .collect(Collectors.toList());
    }

    @Override
    public void modifyById(Integer Id, Client newclient) {

        removeById(Id);
        addOnlyOne(newclient);
    }

    @Override
    public void changePhoneNumber(Integer Id, String newPhoneNumber) {
        for(int i = 0; i < ClientList.size(); i++) {
            if(ClientList.get(i).getClientId() == Id) {
                ClientList.get(i).setPhoneNumber(newPhoneNumber);
            }
        }
    }

    @Override
    public void changeMail(Integer Id, String newMail) {
        for(int i = 0; i < ClientList.size(); i++) {
            if(ClientList.get(i).getClientId() == Id) {
                ClientList.get(i).setMail(newMail);
            }
        }
    }
}
