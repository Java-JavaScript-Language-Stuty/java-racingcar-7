package racingcar.validator;

import java.util.List;

public class InputValidator {
    public static void validateCarNames(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름을 입력해야 합니다.");
        }
        if (carNames.size() != carNames.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복될 수 없습니다.");
        }

        if (carNames.stream().anyMatch(name -> name.length() > 5)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public static void validateAttemptCount(String input) {
        try {
            int count = Integer.parseInt(input);
            if (count <= 0) {
                throw new IllegalArgumentException("[ERROR] 시도 횟수는 1 이상이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해야 합니다.");
        }
    }
}