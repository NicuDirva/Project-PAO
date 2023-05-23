package service.impl;

import Repository.ClientRepository;
import Repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import model.Driver;
import model.Location;
import service.LocationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor

public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;
    @Override
    public Optional<Location> getById(Integer Id) {

        return locationRepository.getObjectById(Id);
    }
    @Override
    public List<Location> getAll() {

        return locationRepository.getAll();
    };


    @Override
    public void addOnlyOne(Location location) {

        locationRepository.addNewObject(location);
    }

    @Override
    public void removeById(Integer Id) {
        locationRepository.deleteObjectById(Id);
    }

    @Override
    public void modifyById(Integer Id, Location newLocation) {

        locationRepository.updateObjectById(Id, newLocation);

    }
}
