package tdd;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    public void 단독우승자를_선정합니다() {
        Car benz = new Car("benz", 1);
        Car audi = new Car("audi", 2);
        Car jeep = new Car("jeep", 3);

        List<Car> carsList = Arrays.asList(benz, audi, jeep);

        Cars cars = new Cars(carsList);

        List<Car> winners = Arrays.asList(jeep);

        assertThat(cars.findWinners()).isEqualTo(winners);
    }

    @Test
    public void 공동우승자를_선정합니다() {
        Car benz = new Car("benz", 3);
        Car audi = new Car("audi", 2);
        Car jeep = new Car("jeep", 3);

        List<Car> carsList = Arrays.asList(benz, audi, jeep);

        Cars cars = new Cars(carsList);

        List<Car> winners = Arrays.asList(benz, jeep);

        assertThat(cars.findWinners()).isEqualTo(winners);
    }
}
