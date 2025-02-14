package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

public class Car {
    private final String name;
    private int position;
    private final RandomNumberGenerator randomNumberGenerator;

    public Car(String name, RandomNumberGenerator randomNumberGenerator) {
        this.name = name;
        this.position = 0;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void move() {
        move(randomNumberGenerator.canMove()); // 기본적으로 랜덤한 이동
    }

    public void move(boolean canMove) {
        if (canMove) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}