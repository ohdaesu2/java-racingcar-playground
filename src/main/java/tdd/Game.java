package tdd;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public List<Car> splitInputString(String inputString) {
        String[] carStrings = inputString.split(",");

        List<Car> carList = new ArrayList<>();
        for (int i=0; i< carStrings.length; i++) {
            String carName = carStrings[i];
            Car car = new Car(carName);
            carList.add(car);
        }
        return carList;
    }

    public List<Car> playGame(List<Car> carList, int round) {
        for (int i = 0; i < round; i++) {
            oneRoundGame(carList);
        }
        Cars cars = new Cars(carList);
        return cars.findWinners();

    }

    private void oneRoundGame(List<Car> carList) {
        for (Car car : carList) {
            car.move();
        }
        showResult(carList);
    }

    private void showResult(List<Car> carList) {
        for (Car car: carList) {
            String resultPosition = new String(new char[car.getPosition()]).replace("\0", "-");
            System.out.println(car.getName() + " : " + resultPosition);
        }
    }
}
