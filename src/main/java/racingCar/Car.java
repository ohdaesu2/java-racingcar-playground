package racingCar;

public class Car {

    public String name;

    public Integer location;

    public Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public String getName() {
        return this.name;
    }

    public Integer getLocation() {
        return this.location;
    }

    public void move() {
        this.location ++;
    }

    public String toString() {
        return this.name;
    }
}
