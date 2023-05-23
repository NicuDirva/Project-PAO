package service.impl;

import Repository.CarRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import model.Car;
import model.enums.Color;
import service.CarService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor


@Getter
@Setter
//@AllArgsConstructor
public class CarServiceImpl implements CarService{

    private final CarRepository carRepository;



    @Override
    public Optional<Car> getById(Integer CarId) {

        return carRepository.getObjectById(CarId);
    }
    @Override
    public List<Car> getAll() {
        return carRepository.getAll();
    };


    @Override
    public void addOnlyOne(Car car) {
        carRepository.addNewObject(car);
    }

    @Override
    public void removeById(Integer CarId) {
        carRepository.deleteObjectById(CarId);
    }

    @Override
    public void modifyById(Integer Id, Car newcar) {

        carRepository.updateObjectById(Id, newcar);

    }

}
