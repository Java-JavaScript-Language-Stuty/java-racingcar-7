package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final int ForwardLeast = 4; //4이상일 때 전진
    private final List<Car> cars = new ArrayList<>();

    public void CarNames(String names){
        String[] carNames = names.split(",");
        for(String name : carNames){
            cars.add(new Car(name.trim()));
        }
    }

    public void moveCars(){
        for(Car car : cars){
            int randomVal = Randoms.pickNumberInRange(0, 9);
            if(randomVal >= ForwardLeast){
                car.move();
            }
        }
    }

    public List<String> getResults(){
        List<String> results = new ArrayList<>();
        for(Car car : cars){
            results.add(car.carPosition());
        }
        return results;
    }

    public String getWinner(){
        int maxPos = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = new ArrayList<>();
        for(Car car : cars){
            if(car.getPosition() == maxPos){
                winners.add(car.getName());
            }
        }
        return String.join(", ", winners);
    }
}
