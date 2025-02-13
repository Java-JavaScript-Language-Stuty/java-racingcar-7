package racingcar.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import racingcar.model.dto.CarMovementDto;

public class Race {
    private int turn;
    private final List<Car> cars;

    private Race() {
        cars = new ArrayList<>();
    }

    public static Race init(List<String> cars) {
        Race race = new Race();
        race.cars.addAll(cars.stream().map(Car::new).toList());
        race.turn = 0;
        return race;
    }

    public void advance(Supplier<Boolean> movementFunction) {
        cars.forEach((car) -> {
            if (movementFunction.get()) {
                car.move();
            }
        });
        turn++;
    }

    public List<CarMovementDto> getResult() {
        return cars.stream().map((Car::getData)).toList();
    }

    public List<String> getWinner() {
        int maxValue = cars.stream()
                .map(car -> car.getData().movement())
                .max(Comparator.naturalOrder()).orElse(0);

        return cars.stream()
                .filter(car -> car.getData().movement() == maxValue)
                .map(car -> car.getData().name())
                .toList();
    }

    public int getTurn() {
        return turn;
    }
}
