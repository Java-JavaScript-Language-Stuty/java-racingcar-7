package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car{
    public int Distance;
    private String Name;

    public Car(String carName){
        Name = carName;
        Distance = 0;
    }



    public String getName(){
        return Name;
    }
    public void setName(String name){Name = name;}
}