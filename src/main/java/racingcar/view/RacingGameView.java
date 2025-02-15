package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.CarObserver;
import racingcar.util.SystemMessage;

public class RacingGameView implements CarObserver {

    public String readName(){
        System.out.println(SystemMessage.START_NAME_GUIDE.getMessage());
        return Console.readLine();
    }

    public String readRepeat(){
        System.out.println(SystemMessage.START_REPEAT_GUIDE.getMessage());
        return Console.readLine();
    }

    public void lineBreak(){
        System.out.println("");
    }

    public void printEndGuide(){
        System.out.println(SystemMessage.RESULT_GUIDE.getMessage());
    }

    public void printFinalWinner(String winner){
        System.out.println(SystemMessage.RESULT_WINNER.getMessage() + winner);
    }

    @Override
    public void onCarMove(String carName, int position){
        //뷰가 모델과 분리되어야해서 인스턴스 말고 각각 보내는게 좋다 함.
        String message = carName + " : " + "-".repeat(position);
        System.out.println(message);
    }
}
