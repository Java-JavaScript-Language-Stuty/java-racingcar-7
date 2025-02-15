package racingcar.util;

public enum ErrorMessage {
    TOOLONG("이름 5자 초과");


    private String message;

    ErrorMessage(String message){this.message = message;}

    public String getMessage() {
        return "Error: "+message;
    }
}
