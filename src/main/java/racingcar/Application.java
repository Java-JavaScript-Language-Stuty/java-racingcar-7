package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.Vector;
import java.util.stream.Collectors;

public class Application {
    static Vector<Player> listOfPlayers = new Vector<>();

    // 레이싱 돌려잇
    static void game(){
        for(int i = 0; i<listOfPlayers.size(); i++){
            if(Randoms.pickNumberInRange(0,9) >=4){
                listOfPlayers.get(i).addDistance();
            }
        }
    }

    // 게임 결과
    static String getGameResult(int player){
        return (listOfPlayers.get(player).getName() + " : "
                + listOfPlayers.get(player).printDistance());
    }

    // 승자의 거리
    static int distanceOfWinner(){
        int answer = 0;
        for(int i = 0; i<listOfPlayers.size();i++){
            if(listOfPlayers.get(i).getDistance() > answer){
                answer = listOfPlayers.get(i).getDistance();
            }
        }
        return answer;
    }

    // 승자 출력
    static String printWinner(){
        int value = distanceOfWinner();
        Vector<String> listOfWinners = new Vector<>();
        for(Player player : listOfPlayers){
            if(player.getDistance() == value){
                listOfWinners.add(player.getName());
            }
        }
        return listOfWinners.stream().collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // input view
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        System.out.println("시도할 횟수는 몇회인가요?");
        int times = Integer.parseInt(Console.readLine());

        // 입력받은 이름들을 player 리스트에 담아줌
        for(String name : names.split(",")){
            Player player = new Player((name));
            listOfPlayers.add(player);
        }

        // output view
        System.out.println("\n실행 결과");
        for(int i = 0; i<times; i++){
            game();
            for(int j = 0; j<listOfPlayers.size(); j++){
                System.out.println(getGameResult(j));;
            }
            System.out.println();
        };
        System.out.printf("최종 우승자 : " + printWinner());
    }
}