package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import racingcar.validator.InputValidator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @Test
    @DisplayName("자동차 이름이 비어있을 경우 예외 발생")
    void validateCarNames_emptyList_throwsException() {
        List<String> emptyList = List.of();
        assertThatThrownBy(() -> InputValidator.validateCarNames(emptyList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름을 입력해야 합니다.");
    }

    @Test
    @DisplayName("자동차 이름이 중복될 경우 예외 발생")
    void validateCarNames_duplicateNames_throwsException() {
        List<String> carNames = Arrays.asList("pobi", "woni", "pobi");
        assertThatThrownBy(() -> InputValidator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과할 경우 예외 발생")
    void validateCarNames_tooLongNames_throwsException() {
        List<String> carNames = Arrays.asList("pobiii", "woni");
        assertThatThrownBy(() -> InputValidator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    @DisplayName("자동차 이름에 특수 문자가 포함될 경우 예외 발생")
    void validateCarNames_invalidCharacters_throwsException() {
        List<String> carNames = Arrays.asList("pobi@", "woni123");
        assertThatThrownBy(() -> InputValidator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 영어 또는 숫자만 가능합니다.");
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아닐 경우 예외 발생")
    void validateAttemptCount_nonNumeric_throwsException() {
        assertThatThrownBy(() -> InputValidator.validateAttemptCount("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효한 숫자를 입력해야 합니다.");
    }

    @Test
    @DisplayName("시도 횟수가 0 이하일 경우 예외 발생")
    void validateAttemptCount_zeroOrNegative_throwsException() {
        assertThatThrownBy(() -> InputValidator.validateAttemptCount("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 시도 횟수는 1 이상이어야 합니다.");
    }

    @Test
    @DisplayName("시도 횟수가 정상적인 경우 예외가 발생하지 않음")
    void validateAttemptCount_validInput_noException() {
        InputValidator.validateAttemptCount("5");
    }
}