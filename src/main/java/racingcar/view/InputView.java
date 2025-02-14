package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> getCarNames() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String input = Console.readLine();

        // , 제거 후 자동차 이름을 배열로 저장
        String[] carNameArray = input.split(",");

        // 배열로 변환
        List<String> carNameList = Arrays.asList(carNameArray);

        if(carNameList.stream().mapToInt(String::length).max().orElse(0) > 5) {
            throw new IllegalArgumentException("5글자 이상 입력함");
        }

        return carNameList;
    }

    public int getTryCount() {

        try {
            System.out.println("시도할 횟수는 몇회인가요?");
            int tryCount = Integer.parseInt(Console.readLine());

            return tryCount;
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 형식을 입력하였습니다", e);
        }

    }
}
