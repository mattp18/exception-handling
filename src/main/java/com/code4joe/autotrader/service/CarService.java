package com.code4joe.autotrader.service;

import com.code4joe.autotrader.exception.CarNotFoundException;
import com.code4joe.autotrader.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private static List<Car> myCars = new ArrayList<>();

    static {
        Car car1 = new Car(1L, "Volvo", "idk" ,"timestamp");
        myCars.add(car1);
        Car car2 = new Car(2L, "Volvo", "idk" ,"timestamp");
        myCars.add(car2);
        Car car3 = new Car(3L, "Volvo", "idk" ,"timestamp");
        myCars.add(car3);
        Car car4 = new Car(4L, "Volvo", "idk" ,"timestamp");
        myCars.add(car4);
    }

   public Car findCarById(Long id) {
        Optional<Car> theCar = myCars.stream().filter(car -> car.getId() == id).findFirst();
        if(!theCar.isPresent()) {
            throw new CarNotFoundException("Could not find car with id: " + id);
        }
        return theCar.get();
   }
}
