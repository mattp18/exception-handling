package com.code4joe.autotrader.controller;

import com.code4joe.autotrader.exception.CarNotFoundException;
import com.code4joe.autotrader.exception.ErrorObject;
import com.code4joe.autotrader.model.Car;
import com.code4joe.autotrader.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping(path = "/findCarById/{id}")
    public Car findCarById(@PathVariable Long id) {
        return carService.findCarById(id);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorObject> handleException(CarNotFoundException ex) {
        ErrorObject error = new ErrorObject(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<ErrorObject>(error, HttpStatus.NOT_FOUND);
    }
}
