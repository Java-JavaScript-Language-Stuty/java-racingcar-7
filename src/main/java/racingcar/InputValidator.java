package racingcar;

import java.util.List;
import java.util.Arrays;

// 올바르지 않은 입력의 경우
// 1. 자동차 이름이 1~5 글자를 벗어날 경우
// 2. 시도 횟수가 숫자가 아닌 경우
// 3. 시도 횟수가 0인 경우

public class InputValidator {

    // 경주할 자동차 입력과 관련한 예외
    public static List<String> validateCarNames(String input) {
        List<String> carNames = Arrays.asList(input.split(","));

        // 1. 자동차 이름이 1~5 글자를 벗어날 경우
        if(carNames.stream().anyMatch(name -> name.length() > 5 || name.length() < 1)) {
            throw new IllegalArgumentException("Car name cannot be longer than 5 and shorter than 1 characters");
        }
        return carNames;
    }

    // 시도 횟수 입력과 관련한 예외
    public static int validateAttempts(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Attempt number cannot be empty.");
        }

        try { // 3. 시도 횟수가 0인 경우
            int attempts = Integer.parseInt(input);
            if (attempts < 1) {
                throw new IllegalArgumentException("Attempt number cannot be less than 1");
            }
            return attempts;
        } catch (NumberFormatException e) { // 2. 시도 횟수가 숫자가 아닌 경우
            throw new IllegalArgumentException("Attempt number must be a number");
        }
    }
}
