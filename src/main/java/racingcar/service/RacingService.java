package racingcar.service;

import racingcar.domain.Race;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.IntStream;

public class RacingService {
    private final RandomNumberGenerator randomNumberGenerator;
    private final OutputView outputView;

    public RacingService(RandomNumberGenerator randomNumberGenerator, OutputView outputView) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.outputView = outputView;
    }

    public void startRace(List<String> carNames, int attemptCount) {
        Race race = new Race(carNames, randomNumberGenerator);
        outputView.printStartMessage();
        runRace(race, attemptCount);
        outputView.printWinners(race.getWinners());
    }

    private void runRace(Race race, int attemptCount) {
        IntStream.range(0, attemptCount)
                .forEach(i -> {
                    race.moveCars();
                    outputView.printRaceStatus(race.getCars());
                });
    }
}