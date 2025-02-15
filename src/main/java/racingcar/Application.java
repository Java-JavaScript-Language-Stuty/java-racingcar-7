package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.service.RacingGameService;
import racingcar.view.RacingGameView;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Application {
    public static void main(String[] args) {
        new Application().run();
    }

    public void run(){
        RacingGameService racingGameService = new RacingGameService();
        RacingGameView racingGameView = new RacingGameView();
        RacingGameController racingGameController = new RacingGameController(racingGameView, racingGameService);

        racingGameController.makeCar();
        racingGameController.runGame();
        racingGameController.result();
    }
}
