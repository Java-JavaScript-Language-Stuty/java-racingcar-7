package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingGame racingGame;

    public RacingGameController(InputView inputView, OutputView outputView, RacingGame racingGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingGame = racingGame;
    }

    public void run() {
        String names=inputView.getCarNames();
    }
}
