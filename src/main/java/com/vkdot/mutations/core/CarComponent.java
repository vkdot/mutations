package com.vkdot.mutations.core;

import com.vkdot.mutations.core.dao.Car;
import java.util.List;
import java.util.stream.Collectors;

public class CarComponent {

  public List<Car> getFilterCars(List<Car> allCars) {
    return allCars
        .stream()
        .filter(car -> car.getBrand() != null && car.getWheels() != null)
        .collect(Collectors.toList());
  }

}
