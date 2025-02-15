package racingcar.model;

import racingcar.util.ErrorMessage;

public class Car {
    private String name;
    private int position;
    private CarObserver observer;

    public Car(String name){
        setName(name);
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length()>5) throw new IllegalArgumentException(ErrorMessage.TOOLONG.getMessage());
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void addPosition(int dice) {
        if(dice>3) this.position++;
        observer.onCarMove(name, position);
    }

    public void setObserver(CarObserver observer) {
        this.observer = observer;
    }
}
