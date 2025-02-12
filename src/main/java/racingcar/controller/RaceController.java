package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.GetWinner;
import racingcar.service.SliceName;
import racingcar.view.RaceView;

import java.util.List;

public class RaceController {
    public static void startRace() {
        String p = RaceView.inputCars();
        int times = RaceView.inputTimes();
        List<String> participant = SliceName.slice(p);

        for (String s : participant) {
            Car.cars.add(new Car(s));
        }

        System.out.println("실행 결과");
        for (int i = 0; i < times; i++) {
            RaceView.interimTally(Car.cars);
        }

        RaceView.outputWinner(GetWinner.getWinner(Car.cars.stream(), GetWinner.getMax(Car.cars.stream())));
    }
}
