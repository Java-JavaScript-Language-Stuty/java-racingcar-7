package racingcar.view;

import java.util.List;
import racingcar.model.dto.CarMovementDto;
import racingcar.utils.MessageConstants;

public class OutputView {
    private final String SEPARATOR = ", ";
    private final String MOVEMENT_DELIMITER = "-";

    public void printResultGuide() {
        System.out.println(MessageConstants.OUTPUT_EXECUTE_RESULT_GUIDE.getMessage());
    }

    public void printPlayerResult(List<CarMovementDto> playerResult) {
        playerResult.forEach((result) ->
                System.out.printf(
                        MessageConstants.OUTPUT_CAR_MOVEMENT.getMessage(), result.getName()
                                + MOVEMENT_DELIMITER.repeat(result.getMovement()))
        );
    }

    public void printWinner(List<String> names) {
        System.out.println(
                MessageConstants.OUTPUT_FINAL_WINNER_GUIDE.getMessage()
                        + String.join(SEPARATOR, names)
        );
    }
}
