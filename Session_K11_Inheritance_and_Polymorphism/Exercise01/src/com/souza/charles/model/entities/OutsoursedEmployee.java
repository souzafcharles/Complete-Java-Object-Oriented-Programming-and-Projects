package com.souza.charles.model.entities;

public class OutsoursedEmployee extends Employee {

    public static final Double ADDITIONAL_RATE = 1.1;

    private Double additionalCharge;

    public OutsoursedEmployee() {
        super();
    }

    public OutsoursedEmployee(String name, Integer hours, Double valuePerHour, Double additionalCharge) {
        super(name, hours, valuePerHour);
        this.additionalCharge = additionalCharge;
    }

    @Override
    public Double payment(){
        return super.payment() + (additionalCharge * ADDITIONAL_RATE);
    }
}