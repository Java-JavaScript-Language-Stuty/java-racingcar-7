package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.model.RacingGame;

public class Application {
    static AppConfig appConfig;
    static RacingGameController racingGameController;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        appConfig = new AppConfig();
        racingGameController=appConfig.racingGameController();
        racingGameController.run();
    }
}
