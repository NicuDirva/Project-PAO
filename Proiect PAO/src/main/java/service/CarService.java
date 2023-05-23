package service;

import lombok.Getter;
import lombok.Setter;
import model.Car;
import model.enums.Color;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//@Setter
//@Getter
public interface CarService {

    public Optional<Car> getById(Integer Id);

    List<Car> getAll();


    void addOnlyOne(Car car);

    void removeById(Integer id);

    void modifyById(Integer id, Car newcar);

}
