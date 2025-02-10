package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {
    public InputView inputView(){
        return new InputView();
    }
    public OutputView outputView(){
        return new OutputView();
    }
    public RacingGame racingGame(){
        return new RacingGame();
    }
    public RacingGameController racingGameController(){
        return new RacingGameController(
                this.inputView(),
                this.outputView(),
                this.racingGame()
        );
    }
}

