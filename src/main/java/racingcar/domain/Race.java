package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;

    public Race(List<String> carNames, RandomNumberGenerator randomNumberGenerator) {
        this.cars = carNames.stream()
                .map(name -> new Car(name, randomNumberGenerator))
                .collect(Collectors.toList());
    }

    public void moveCars() {
        cars.forEach(Car::move);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}