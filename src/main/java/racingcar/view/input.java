package racingcar.view;

import java.util.StringTokenizer;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class input{
    private int trial;
    public ArrayList<String> Cars = new ArrayList<>();

    public input(){
        trial = 0;
    }
    public ArrayList<String> getCarName(){
        return Cars;
    }

    public void setCarName() {
        String CarNames = Console.readLine();
        StringTokenizer separatedCarNames = new StringTokenizer(CarNames, ",");

        while(separatedCarNames.hasMoreTokens()){
            if (separatedCarNames.nextToken().trim().length() < 5) {
                String oneOfCarName = separatedCarNames.nextToken().trim();
                Cars.add(oneOfCarName);
            }
            else {
                throw new IllegalArgumentException("다섯 글자가 넘어요");
            }
        }
    }

    public void setTrial(){
        trial = Integer.parseInt(Console.readLine());
    }

    public int getTrial(){
        return trial;
    }
}
