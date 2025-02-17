package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Game;
import racingcar.InputValidator;
import java.util.List;
import java.lang.String;

public class Application {
    public static void main(String[] args) {

        // 경주 할 자동차 입력받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = InputValidator.validateCarNames(Console.readLine());

        // 시도 할 횟수 입력받기
        System.out.println("시도할 회수는 몇회인가요?");
        int attempts = InputValidator.validateAttempts(Console.readLine());

        // 게임 진행
        Game game = new Game(carNames, attempts);
        game.start();
    }
}
