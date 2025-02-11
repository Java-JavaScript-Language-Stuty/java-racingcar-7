package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

public class ViewTest {
    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView(new MockInputProvider("pobi,woni,jun", "5"));
    }

    @Test
    void carNameInputTest() {
        String carNames = inputView.getCarName();
        assertEquals("pobi,woni,jun", carNames);
    }

    @Test
    void trialInputTest() {
        inputView.getCarName();
        int trialNumber = inputView.getTrialNumber();
        assertEquals(5, trialNumber);
    }
}
