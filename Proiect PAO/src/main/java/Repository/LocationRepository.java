package Repository;

import model.Car;
import model.Location;

import java.util.List;
import java.util.Optional;

public interface LocationRepository {
    Optional<Location> getObjectById(Integer id);

    void deleteObjectById(Integer id);

    void updateObjectById(Integer id, Location newObject);

    void addNewObject(Location location);

    List<Location> getAll();

    void addAllFromGivenList(List<Location> locationList);
}
