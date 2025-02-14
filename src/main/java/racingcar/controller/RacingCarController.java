package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;

import racingcar.view.*;
import racingcar.model.Car;
import java.util.ArrayList;

public class RacingCarController{
    public int numbersOfCar = 1;
    public Car[] car = new Car[numbersOfCar];

    public void setCar(ArrayList<String> carName){
        numbersOfCar = carName.size();
        for (int i = 0; i < numbersOfCar; i++){
            car[i].setName(carName.get(i));
            car[i].Distance = 0;
        }
    }

    public int getNumbersOfCar(){
        return numbersOfCar;
    }

    public void RacingGame() {
        output.CarNameRequestMessage();
        input userInput = new input();
        userInput.setCarName();

        output.trialRequestMessage();
        userInput.setTrial();

        setCar(userInput.getCarName());

        for (int k = 0; k < userInput.getTrial(); k++){
            for (int i = 0; i < numbersOfCar; i++) {
                int randomDistance = Randoms.pickNumberInRange(0, 9);
                car[i].Distance += randomDistance;
            }

            System.out.print(car[k].getName() + " : ");
            for (int i = 0; i < car[i].Distance; i++){
                if (i != car[i].Distance){
                    System.out.print("-");
                }
                else {
                    System.out.println("-");
                }
            }
        }
    }
}