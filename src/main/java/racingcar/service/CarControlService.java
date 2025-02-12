package racingcar.service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import racingcar.model.dto.CarMovementDto;
import racingcar.model.dto.Race;

public class CarControlService {
    private Race race;

    public void initialize(String names) {
        this.race = Race.init(parseNames(names));
    }

    private List<String> parseNames(String names) {
        return Arrays.stream(names.trim().split(",")).toList();
    }

    public List<CarMovementDto> playTurn(Supplier<Boolean> movementFunction) {
        race.advance(movementFunction);
        return race.getResult();
    }

    public List<String> getWinner() {
        return race.getWinner();
    }
}
