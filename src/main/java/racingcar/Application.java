package racingcar;


import racingcar.controller.*;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현


        RacingCarController start = new RacingCarController();
        start.RacingGame();

        WhoIsWinner w = new WhoIsWinner();
        w.JudgeWinner(start);
    }
}
