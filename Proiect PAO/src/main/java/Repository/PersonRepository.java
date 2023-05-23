package Repository;

import model.Car;
import model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {
    Optional<Person> getObjectById(Integer id);

    void deleteObjectById(Integer id);

    void updateObjectById(Integer id, Person newObject);

    void addNewObject(Person person);

    List<Person> getAll();

    void addAllFromGivenList(List<Person> personList);
}
