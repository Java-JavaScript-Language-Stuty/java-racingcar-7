package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.CheckInput;
import racingcar.service.GetWinner;
import racingcar.service.SliceName;
import racingcar.view.RaceView;

import java.util.List;

public class RaceController {
    public static void startRace() {
        String p = RaceView.inputCars();
        int times = CheckInput.checkNumber(RaceView.inputTimes());

        List<String> participant = CheckInput.checkName(p);

        for (String s : participant) {
            Car.cars.add(new Car(s));
        }

        RaceView.outputResult(times);

        RaceView.outputWinner(GetWinner.getWinner(Car.cars.stream(), GetWinner.getMax(Car.cars.stream())));
    }
}
