package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.view.InputView;

import java.util.List;

public class RacingGameController {
    private final InputView inputView;
    private final RacingService racingService;

    public RacingGameController(InputView inputView, RacingService racingService) {
        this.inputView = inputView;
        this.racingService = racingService;
    }

    public void run() {
        List<String> carNames = inputView.getCarNames();
        int attemptCount = inputView.getAttemptCount();

        racingService.startRace(carNames, attemptCount);
    }
}