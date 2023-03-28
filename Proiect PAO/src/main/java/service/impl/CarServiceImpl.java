package service.impl;

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


@Getter
@Setter
//@AllArgsConstructor
public class CarServiceImpl implements CarService{

    private static List<Car> carList = new ArrayList<>();
    @Override
    public Optional<Car> getById(Integer CarId) {

        return carList.stream()
                .filter(object -> CarId.equals(object.getCarId()))
                .findFirst();
    }
    @Override
    public List<Car> getAll() {
        return carList;
    };


    @Override
    public void addOnlyOne(Car car) {
        carList.add(car);
    }

    @Override
    public void removeById(Integer CarId) {
        carList = carList.stream()
                .filter(object -> !CarId.equals(object.getCarId()))
                .collect(Collectors.toList());
    }

    @Override
    public void modifyById(Integer Id, Car newcar) {

        removeById(Id);
        addOnlyOne(newcar);

    }

    @Override
    public void changeColor(Integer Id, Color newColor) {
        for(Car car : carList) {
            if(car.getCarId() == Id) {
                car.setColor(newColor);
            }
        }
    }

}
