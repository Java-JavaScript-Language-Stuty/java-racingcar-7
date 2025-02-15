package racingcar.util;

public enum SystemMessage {
    START_NAME_GUIDE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    START_REPEAT_GUIDE("시도할 회수는 몇 회인가요?"),
    RESULT_GUIDE("실행 결과"),
    RESULT_WINNER("최종 우승자 : ");


    private String message;

    SystemMessage(String message){this.message = message;}

    public String getMessage() {
        return this.message;
    }
}
