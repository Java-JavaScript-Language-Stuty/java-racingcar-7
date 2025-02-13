package racingcar.controller;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.dto.CarMovementDto;
import racingcar.service.CarControlService;
import racingcar.service.RandomService;
import racingcar.utils.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {
    InputView inputView;
    OutputView outputView;
    CarControlService carControlService;
    RandomService randomService;

    private int trials;

    public RacingcarController(InputView inputView, OutputView outputView,
                               CarControlService carControlService, RandomService randomService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carControlService = carControlService;
        this.randomService = randomService;
    }

    public void run() {
        initialize();
        execute();
        getResult();
    }

    private void initialize() {
        String names = inputView.getCarName();
        trials = inputView.getTrialNumber();
        Validator.naturalNumberCheck(trials);
        carControlService.initialize(names);
        outputView.newLine();
    }

    private void execute() {
        outputView.printResultGuide();
        IntStream.range(0, trials).forEach((t) -> {
            List<CarMovementDto> progress = carControlService.playTurn(randomService::willCarMove);
            outputView.printPlayerResult(progress);
            outputView.newLine();
        });
    }

    private void getResult() {
        List<String> winner = carControlService.getWinner();
        outputView.printWinner(winner);
    }
}
