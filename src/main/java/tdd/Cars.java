package tdd;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> carsList) {
        this.cars = carsList;
    }

    public List<Car> findWinners() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (maxPosition < car.getPosition()) {
                maxPosition = car.getPosition();
            }
        }

        List<Car> winners = new ArrayList<>();
        for (Car winner: cars) {
            if (winner.getPosition() == maxPosition) {
                winners.add(winner);
            }
        }

        return winners;
    }

    @Override
    public String toString() {
        return cars.toString();
    }
}
