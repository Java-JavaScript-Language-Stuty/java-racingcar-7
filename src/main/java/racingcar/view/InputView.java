package racingcar.view;

import racingcar.utils.MessageConstants;
import racingcar.view.provider.InputProvider;

public class InputView {
    private final InputProvider inputProvider;

    public InputView(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    public String getCarName() {
        try {
            System.out.println(MessageConstants.INPUT_CAR_NAME_GUIDE.getMessage());
            return inputProvider.readLine();
        } catch (Exception exception) {
            throw new IllegalArgumentException("[Error] 입출력 과정에서 예외가 발생했습니다. ");
        }
    }

    public int getTrialNumber() {
        try {
            System.out.println(MessageConstants.INPUT_TRIAL_NUMBER_GUIDE.getMessage());
            return Integer.parseInt(inputProvider.readLine());
        } catch (Exception exception) {
            throw new IllegalArgumentException("[Error] 입출력 과정에서 예외가 발생했습니다. ");
        }
    }
}
