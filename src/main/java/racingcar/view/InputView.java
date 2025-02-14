package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carNames = Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(name -> !name.isEmpty()) // 빈 문자열 제거
                .collect(Collectors.toList());
        InputValidator.validateCarNames(carNames);
        return carNames;
    }

    public int getAttemptCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        InputValidator.validateAttemptCount(input);
        return Integer.parseInt(input);
    }
}