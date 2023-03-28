package service.impl;

import model.Location;
import model.Person;
import service.PersonService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonServiceImpl implements PersonService{
    private static List<Person> PersonList = new ArrayList<>();
    @Override
    public Optional<Person> getById(Integer Id) {

        return PersonList.stream()
                .filter(object -> Id.equals(object.getPersonId()))
                .findFirst();
    }
    @Override
    public List<Person> getAll() {
        return PersonList;
    };


    @Override
    public void addOnlyOne(Person person) {
        PersonList.add(person);
    }

    @Override
    public void removeById(Integer Id) {
        PersonList = PersonList.stream()
                .filter(object -> !Id.equals(object.getPersonId()))
                .collect(Collectors.toList());
    }

    @Override
    public void modifyById(Integer Id, Person newPerson) {

        removeById(Id);
        addOnlyOne(newPerson);

    }
}
