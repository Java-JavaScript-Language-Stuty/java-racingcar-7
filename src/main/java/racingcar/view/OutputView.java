package racingcar.view;

import java.util.stream.Collectors;
import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    public void printStartMessage() {
        System.out.println("\n실행 결과");
    }

    public void printRaceStatus(List<Car> cars) {
        String raceStatus = cars.stream()
                .map(car -> car.getName() + " : " + "-".repeat(Math.max(0, car.getPosition())))
                .collect(Collectors.joining("\n"));

        System.out.println(raceStatus + "\n");
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}