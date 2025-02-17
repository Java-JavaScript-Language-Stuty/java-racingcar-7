package racingcar;

import racingcar.Car;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final List<Car> cars;
    private final int attempts;

    // Game 클래스의 생성자
    public Game(List<String> carNames, int counts) {
        this.cars = carNames.stream().map(name -> new Car(name)).collect(Collectors.toList());
        this.attempts = counts;
    }

    // 게임 시작 메소드
    public void start() {
        System.out.println("실행 결과");
        run();
    }

    // 게임 진행 메소드
    private void run() {
        for(int i = 0; i < attempts; i++) {
            for(Car car : cars) {
                car.move();
            }
            printStatus();
        }
        printWinner();
    }

    // 게임 과정 출력 메소드
    private void printStatus() {
        for(Car car : cars) {
            System.out.println(car.getStatus());
        }
        System.out.println();
    }

    // 최종 우승자 출력 메소드
    private void printWinner() {
        // 1. 최고 거리 찾기
        int winnerDistance = cars.stream().mapToInt(Car::getPosition).max().orElse(0);

        // 2. 최고 거리를 간 자동차 찾기
        List<String> winnerNames = cars.stream().filter(car -> car.getPosition() == winnerDistance).map(Car::getName).collect(Collectors.toList());

        // 3. 최종 우승자 출력
        System.out.println("최종 우승자 : " + String.join(", ", winnerNames));
    }
}
