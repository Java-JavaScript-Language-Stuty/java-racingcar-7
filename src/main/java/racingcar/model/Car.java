package racingcar.model;

import racingcar.model.dto.CarMovementDto;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        position = 0;
    }

    public CarMovementDto getData() {
        return new CarMovementDto(name, position);
    }

    public void move() {
        position++;
    }
}
