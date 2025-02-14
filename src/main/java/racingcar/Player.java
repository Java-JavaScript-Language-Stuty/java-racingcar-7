package racingcar;

public class Player {
    private String name;
    private int distance;
    Player(){
        this.name = "";
        this.distance = 0;
    }
    Player(String name){
        this.name = name;
        this.distance = 0;
    }
    void addDistance(){
        distance++;
    }
    String getName(){
        return name;
    }
    String printDistance(){
        String answer = "";
        for(int i = 0; i<distance;i++){
            answer += "-";
        }
        return answer;
    }
    int getDistance(){
        return distance;
    }
}
