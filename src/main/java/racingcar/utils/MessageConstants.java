package racingcar.utils;

public enum MessageConstants {
    INPUT_CAR_NAME_GUIDE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_TRIAL_NUMBER_GUIDE("시도할 회수는 몇회인가요?"),
    OUTPUT_EXECUTE_RESULT_GUIDE("실행 결과"),
    OUTPUT_FINAL_WINNER_GUIDE("최종 우승자 : "),
    OUTPUT_CAR_MOVEMENT("%s : ");

    private final String message;

    MessageConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
