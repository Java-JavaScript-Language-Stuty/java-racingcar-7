package racingcar.util;

public enum ErrorMessage {
    TOO_LONG("이름 5자 초과"),
    WRONG_REPEAT_INPUT("입력 반복 횟수는 1 이상의 숫자여야합니다.");


    private String message;

    ErrorMessage(String message){this.message = message;}

    public String getMessage() {
        return "Error: "+message;
    }
}
