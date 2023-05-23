package Repository;

import model.Car;

import java.util.List;
import java.util.Optional;

public interface CarRepository {
    Optional<Car> getObjectById(Integer id);

    void deleteObjectById(Integer id);

    void updateObjectById(Integer id, Car newObject);

    void addNewObject(Car car);

    List<Car> getAll();

    void addAllFromGivenList(List<Car> carsList);

}
