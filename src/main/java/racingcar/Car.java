package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String carName;
    private int position = 0;

    // Car 클래스 생성자
    public Car(String name) {
        if(name.length() > 5) { // 자동차 이름의 길이가 5 초과일 경우 예외 발생
            throw new IllegalArgumentException("Car name cannot be longer than 5 characters");
        }
        this.carName = name;
    }

    // 객체 움직임 정의 :
    public void move() {
        int value = Randoms.pickNumberInRange(0,9);
        if(value >= 4) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return carName;
    }

    public String getStatus() {
        return carName + " : " + "-".repeat(position);
    }
}
