package racingCar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameService {

    CarService carService = new CarService();

    private String[] splitCar(String string) {
        return string.split(",");
    }

    public ArrayList<Car> generateCarList(String inputString) throws Exception{
        ArrayList<Car> carList = new ArrayList<>();

        String[] carsString = splitCar(inputString);

        for (int i=0; i<carsString.length; i++) {
            Car car = carService.createCar(carsString[i]);
            carList.add(car);
        }

        return carList;
    }

    public void playGame(int round, List<Car> carsList) {
        for (int i=0; i<round; i++) {
            carService.moveCars(carsList);
            showResult(carsList);
        }

        List<Car> winner = getResult(carsList);

        System.out.println(winner +"가 최종우승 하였습니다.");


    }

    public void showResult(List<Car> carsList) {
        for (int i=0; i< carsList.size(); i++) {
            Car car = carsList.get(i);
            String location = new String(new char[car.getLocation()]).replace("\0", "-");
            System.out.println(car.getName() + " : " + location);
        }
    }

    public List<Car> getResult(List<Car> carsList) {
        ArrayList<Integer> locationList = new ArrayList<>();
        ArrayList<Car> result = new ArrayList<>();

        for(int i=0; i<carsList.size(); i++) {
            Integer location = carsList.get(i).getLocation();
            locationList.add(location);
        }

        Integer maxValue = Collections.max(locationList);

        while (locationList.contains(maxValue)){
            Integer index = locationList.indexOf(maxValue);
            Car car = carsList.get(index);
            result.add(car);
            locationList.set(index, -1);
        }

        return result;

    }

}
