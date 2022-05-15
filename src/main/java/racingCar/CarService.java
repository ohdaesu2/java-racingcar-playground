package racingCar;

import java.util.List;
import java.util.Random;

public class CarService {

    private static Integer MINIMUM_NUMBER_TO_MOVE = 4;

    public void validateCarName(Car car) throws Exception {
        String carName = car.getName();
        if (carName.length() < 1 || carName.length() >5 ) {
            throw new CarNameException();
        }
    }

    public Car createCar(String carName) throws Exception {
        Car car = new Car(carName);
        validateCarName(car);
        return car;
    }

    public void moveCars(List<Car> cars) {
        for (int i=0; i<cars.size(); i++) {
            moveCar(cars.get(i));
        }
    }

    public void moveCar(Car car) {
        Integer randomNumber = getRandomNumber();
        StatusEnum status = getStatus(randomNumber);
        if (status.equals(StatusEnum.MOVE)) {
            car.move();
        }
    }

    public StatusEnum getStatus(Integer number) {
        if (number >= MINIMUM_NUMBER_TO_MOVE) {
            return StatusEnum.MOVE;
        }
        return StatusEnum.STOP;
    }

    private Integer getRandomNumber() {
        Random random = new Random();
        return random.nextInt(9);
    }

}
