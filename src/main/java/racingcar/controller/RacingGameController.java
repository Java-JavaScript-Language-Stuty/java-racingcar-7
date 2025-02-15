package racingcar.controller;

import racingcar.service.RacingGameService;
import racingcar.view.RacingGameView;

import java.util.List;

public class RacingGameController {

    private RacingGameView racingGameView;
    private RacingGameService racingGameService;

    public RacingGameController(RacingGameView racingGameView, RacingGameService racingGameService){
        this.racingGameService = racingGameService;
        this.racingGameView = racingGameView;
    }

    public void makeCar(){
        String[] carNames = racingGameView.readName().split(",");
        for(String name : carNames) racingGameService.addCar(name);
        racingGameService.addObserver(racingGameView);
    }

    public void runGame(){
        int repetitionNumber = Integer.parseInt(racingGameView.readRepeat());
        racingGameView.printEndGuide();
        for (int i=0;i<repetitionNumber;i++) {
            racingGameService.playOneGame();
            racingGameView.lineBreak();
        }
    }

    public void result(){
        String winners = racingGameService.checkWinner();
        racingGameView.printFinalWinner(winners);

    }
}
