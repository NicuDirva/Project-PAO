package service;

import model.Driver;
import model.Location;

import java.util.List;
import java.util.Optional;

public interface LocationService {
    public Optional<Location> getById(Integer Id);

    List<Location> getAll();

    void addOnlyOne(Location location);

    void removeById(Integer id);

    void modifyById(Integer id, Location newlocation);
}
