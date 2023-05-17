package com.code4joe.autotrader.model;

import lombok.Data;

@Data
public class Car {

    public Car(Long id, String manufacture, String model, String timeStamp) {
        this.id = id;
        this.manufacture = manufacture;
        this.model = model;
        this.timeStamp = timeStamp;
    }

    private Long id;

    private String manufacture;

    private String model;

    private String timeStamp;


}
