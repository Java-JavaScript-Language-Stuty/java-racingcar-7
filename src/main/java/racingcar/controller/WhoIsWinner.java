package racingcar.controller;

import java.util.List;
import java.util.ArrayList;

public class WhoIsWinner{
    public List<String> winner= new ArrayList<>();

    public void JudgeWinner(RacingCarController cars){
        int maxDistance = 0;

        for (int i = 0; i < cars.getNumbersOfCar(); i++){
            if (cars.car[i].Distance > maxDistance){
                maxDistance = cars.car[i].Distance;
            }
        }

        for (int i = 0; i < cars.getNumbersOfCar(); i++){
            if (cars.car[i].Distance == maxDistance){
                winner.add(cars.car[i].getName());
            }
        }

        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winner.size(); i++){
            if (i != winner.size()-1) {
                System.out.print(winner.getFirst() + ",");
                winner.removeFirst();
            }
            else {
                System.out.print(winner.getFirst());
                winner.removeFirst();
            }
        }
    }
}