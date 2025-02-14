package racingcar.config;

import racingcar.controller.RacingGameController;
import racingcar.service.RacingService;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {
    private final RacingGameController racingGameController;

    public AppConfig() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingService racingService = new RacingService(randomNumberGenerator, outputView);
        this.racingGameController = new RacingGameController(inputView, racingService);
    }

    public RacingGameController getRacingGameController() {
        return racingGameController;
    }
}