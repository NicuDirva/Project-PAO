package service;

import model.Location;
import model.Order;
import model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    public Optional<Person> getById(Integer Id);

    List<Person> getAll();

    void addOnlyOne(Person person);

    void removeById(Integer id);

    void modifyById(Integer id, Person newPerson);

}
