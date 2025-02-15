package racingcar.model;

public interface CarObserver {
    void onCarMove(String carName, int position);
}
