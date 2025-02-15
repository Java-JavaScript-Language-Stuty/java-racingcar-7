package racingcar.service;

import racingcar.model.Car;
import racingcar.model.CarObserver;

import java.net.CacheRequest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RacingGameService {
    private List<Car> cars = new ArrayList<>();

    public void addCar(String carName){
        Car car = new Car(carName);
        cars.add(car);
    }

    public void addObserver(CarObserver carObserver){
        cars.forEach(car->car.setObserver(carObserver));
    }

    public void playOneGame(){
        for(Car car : cars) car.addPosition(pickNumberInRange(0,9));
    }

    public String checkWinner(){
        Optional<Integer> maxValue = cars.stream().map(Car::getPosition).max(Integer::compareTo);

        String maxPositionCars = cars.stream()
                .filter(n -> maxValue.isPresent() && n.getPosition()==maxValue.get())
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        return maxPositionCars;
    }
}
