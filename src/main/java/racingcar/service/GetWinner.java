package racingcar.service;

import racingcar.model.Car;

import java.util.List;
import java.util.stream.Stream;

public class GetWinner {
    public static int getMax(Stream<Car> c) {
        return c.map(Car::getCount).max(Integer::compare).get();
    }

    public static String getWinner(Stream<Car> c, int max) {
        List<String> result = c.filter(car -> car.getCount() == max).map(Car::getName).toList();
        return String.join(", ", result);
    }
}
