package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getCarNames() { //이름 입력받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }
    public int getRoundCount() { //회수 입력받기
        System.out.println("시도할 회수는 몇회인가요?");
        try{
            return Integer.parseInt(Console.readLine());
        }
        catch(NumberFormatException e){
            System.out.println("올바른 숫자를 입력하세요.");
            return getRoundCount(); //제대로 할때까지 무한입력
        }
    }
}
