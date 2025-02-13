package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.dto.CarMovementDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class ViewTest extends NsTest {
    private InputView inputView;
    private OutputView outputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView(new MockInputProvider("pobi,woni,jun", "5"));
        outputView = new OutputView();
    }

    @Nested
    @DisplayName("입력 테스트")
    class InputTest {
        @Test
        @DisplayName("차 이름 테스트")
        void carNameInputTest() {
            String carNames = inputView.getCarName();
            assertEquals("pobi,woni,jun", carNames);
        }

        @Test
        @DisplayName("시도 횟수 테스트")
        void trialInputTest() {
            inputView.getCarName();
            int trialNumber = inputView.getTrialNumber();
            assertEquals(5, trialNumber);
        }
    }

    @Nested
    @DisplayName("출력 테스트")
    class OutputTest {
        @Test
        @DisplayName("결과 메시지 출력 테스트")
        void printResultGuideTest() {
            assertSimpleTest(() -> {
                outputView.printResultGuide();
                assertThat(output()).contains("실행 결과");
            });
        }

        @Test
        @DisplayName("경주 진행 출력 테스트")
        void printPlayerResultTest() {
            assertSimpleTest(() -> {
                outputView.printPlayerResult(
                        List.of(
                                new CarMovementDto("pobi", 4),
                                new CarMovementDto("woni", 0),
                                new CarMovementDto("jun", 1)
                        )
                );
                assertThat(output()).isEqualTo("pobi : ----\nwoni : \njun : -");
            });
        }

        @ParameterizedTest
        @DisplayName("우승자 출력 테스트")
        @CsvSource({"pobi", "pobi, jun", "pobi, woni, jun"})
        void printWinnerTest(String winners) {
            assertSimpleTest(() -> {
                List<String> winnerList = List.of(winners.split(", "));
                outputView.printWinner(winnerList);
                assertThat(output()).isEqualTo("최종 우승자 : " + winners);
            });
        }
    }

    @Override
    public void runMain() {
    }
}
