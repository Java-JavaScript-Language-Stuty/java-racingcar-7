package racingcar.service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import racingcar.model.Race;
import racingcar.model.dto.CarMovementDto;
import racingcar.utils.Validator;

public class CarControlService {
    private Race race;

    private static final int MIN_CHAR_LENGTH = 1;
    private static final int MAX_CHAR_LENGTH = 5;

    public void initialize(String names) {
        List<String> nameList = parseNames(names);
        validateName(nameList);
        this.race = Race.init(nameList);
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

    private void validateName(List<String> nameList) {
        nameList.forEach((name) -> Validator.stringRangeCheck(name, MIN_CHAR_LENGTH, MAX_CHAR_LENGTH));
        Validator.duplicationCheck(nameList);
    }
}
