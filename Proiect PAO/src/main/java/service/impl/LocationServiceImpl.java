package service.impl;

import model.Driver;
import model.Location;
import service.LocationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LocationServiceImpl implements LocationService {
    private static List<Location> LocationList = new ArrayList<>();
    @Override
    public Optional<Location> getById(Integer Id) {

        return LocationList.stream()
                .filter(object -> Id.equals(object.getLocationId()))
                .findFirst();
    }
    @Override
    public List<Location> getAll() {
        return LocationList;
    };


    @Override
    public void addOnlyOne(Location location) {
        LocationList.add(location);
    }

    @Override
    public void removeById(Integer Id) {
        LocationList = LocationList.stream()
                .filter(object -> !Id.equals(object.getLocationId()))
                .collect(Collectors.toList());
    }

    @Override
    public void modifyById(Integer Id, Location newLocation) {

        removeById(Id);
        addOnlyOne(newLocation);

    }
}
