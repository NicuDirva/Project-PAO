package service.impl;

import Repository.ClientRepository;
import Repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import model.Location;
import model.Person;
import service.PersonService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@RequiredArgsConstructor

public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;
    @Override
    public Optional<Person> getById(Integer Id) {

        return personRepository.getObjectById(Id);
    }
    @Override
    public List<Person> getAll() {
        return personRepository.getAll();
    };


    @Override
    public void addOnlyOne(Person person) {

        personRepository.addNewObject(person);
    }

    @Override
    public void removeById(Integer Id) {
        personRepository.deleteObjectById(Id);
    }

    @Override
    public void modifyById(Integer Id, Person newPerson) {

        personRepository.updateObjectById(Id, newPerson);

    }
}
