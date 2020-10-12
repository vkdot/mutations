package com.vkdot.mutations.core.dao;

public class Car {

  private final String brand;
  private final Integer wheels;

  public Car(String brand, Integer wheels) {
    this.brand = brand;
    this.wheels = wheels;
  }

  public String getBrand() {
    return brand;
  }

  public Integer getWheels() {
    return wheels;
  }
}
