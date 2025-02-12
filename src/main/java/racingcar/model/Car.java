package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Car {
    public static List<Car> cars = new ArrayList<>();

    String name;
    int count;

    public Car(String name) {
        this.name = name;
        this.count = 0;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void forward() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            count++;
        }
    }

    public void printResult() {
        System.out.println(name + " : " + "-".repeat(count));
    }
}
