package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;

import java.util.List;

public class RaceView {
    public static String inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }
    public static int inputTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
        String t = Console.readLine();

        if (Integer.parseInt(t) > 0) return Integer.parseInt(t);

        throw new IllegalArgumentException();
    }

    public static void interimTally(List<Car> c) {
        for (Car car : c ) {
            car.forward();
        }
        for (Car car : c ) {
            car.printResult();
        }
        System.out.println();
    }

    public static void outputWinner(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }
}
