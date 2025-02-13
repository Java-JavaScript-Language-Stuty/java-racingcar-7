package racingcar.model;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        if(name.length() > 5) { //5자 제한
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
        this.position = 0;
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String carPosition() {
        return name + " : " + "-".repeat(position);
    }
}
