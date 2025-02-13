package racingcar;

import racingcar.controller.RacingcarController;
import racingcar.service.CarControlService;
import racingcar.service.RandomService;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.provider.InputProvider;
import racingcar.view.provider.WoowaInputProvider;

public class AppConfig {
    public InputProvider inputProvider() {
        return new WoowaInputProvider();
    }

    public InputView inputView() {
        return new InputView(inputProvider());
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public CarControlService carControlService() {
        return new CarControlService();
    }

    public RandomService randomService() {
        return new RandomService();
    }

    public RacingcarController racingcarController() {
        return new RacingcarController(
                inputView(),
                outputView(),
                carControlService(),
                randomService()
        );
    }
}
