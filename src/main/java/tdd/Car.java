package tdd;

import java.util.Random;

public class Car {

    private static int MINIMUM_NUMBER_TO_MOVE = 4;

    private String name;

    private int position;

    public Car(String name) {
        if (name.length() > 5 || name.length() < 1) {
            throw new IllegalStateException("자동차 이름의 길이는 1글자에서 5글자 입니다.");
        }
        this.name = name;
        this.position = 0;
    }

    public Car(String name, int position) {
        if (name.length() > 5 || name.length() < 1) {
            throw new IllegalStateException("자동차 이름의 길이는 1글자에서 5글자 입니다.");
        }
        this.name = name;
        this.position = position;
    }

    public void move(int number) {
        if (number >= MINIMUM_NUMBER_TO_MOVE) {
            this.position ++;
        }
    }

    public void move() {
        int randomNumber = getRandomNumber();
        if (randomNumber >= MINIMUM_NUMBER_TO_MOVE) {
            this.position ++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(9);
    }

    @Override
    public String toString() {
        return name;
    }
}
