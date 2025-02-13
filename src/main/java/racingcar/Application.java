package racingcar;

import racingcar.controller.RacingcarController;

public class Application {
    static AppConfig appConfig;
    static RacingcarController racingcarController;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        appConfig = new AppConfig();
        racingcarController = appConfig.racingcarController();

        racingcarController.run();
    }
}
