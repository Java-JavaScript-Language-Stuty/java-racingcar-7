package racingcar.view;

import java.util.List;

public class OutputView {
    public void printRace(List<String> raceResults) {
        for (String result : raceResults) {
            System.out.println(result);
        }
        System.out.println();
    }
    public void printWinners(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}
