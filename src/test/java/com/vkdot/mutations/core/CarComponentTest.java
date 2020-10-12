package com.vkdot.mutations.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.vkdot.mutations.core.dao.Car;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.powermock.reflect.Whitebox;

@RunWith(BlockJUnit4ClassRunner.class)
public class CarComponentTest {

  private CarComponent component;

  @Before
  public void setUp() {
    component = new CarComponent();
  }

  @Test
  public void getFilterCars() {
    List<Car> cars = component.getFilterCars(
        List.of(
            new Car("VW", 4),
            new Car("Skoda", 4),
            new Car(null, 4),
            new Car("Morgan", null)
        )
    );

    assertEquals(2, cars.size());
    assertEquals("VW", cars.get(0).getBrand());
    assertEquals(4, cars.get(0).getWheels().intValue());
    assertEquals("Skoda", cars.get(1).getBrand());
    assertEquals(4, cars.get(1).getWheels().intValue());
  }
}
