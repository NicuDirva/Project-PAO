package service.impl;

import Repository.CarRepository;
import Repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import model.Client;
import service.ClientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor

public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    @Override
    public Optional<Client> getById(Integer Id) {

        return clientRepository.getObjectById(Id);
    }
    @Override
    public List<Client> getAll() {
        return clientRepository.getAll();
    };


    @Override
    public void addOnlyOne(Client client) {

        clientRepository.addNewObject(client);
    }

    @Override
    public void removeById(Integer Id) {
        clientRepository.deleteObjectById(Id);
    }

    @Override
    public void modifyById(Integer Id, Client newclient) {

        clientRepository.updateObjectById(Id, newclient);
    }

}
