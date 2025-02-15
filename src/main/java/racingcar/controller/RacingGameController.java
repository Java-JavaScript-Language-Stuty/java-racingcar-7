package racingcar.controller;

import racingcar.service.RacingGameService;
import racingcar.util.ErrorMessage;
import racingcar.util.Validator;
import racingcar.view.RacingGameView;

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
        String input = racingGameView.readRepeat();
        if(!Validator.isNumber(input)) throw new IllegalArgumentException(ErrorMessage.WRONG_REPEAT_INPUT.getMessage());

        int repetitionNumber = Integer.parseInt(input);
        if(repetitionNumber<1)
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
