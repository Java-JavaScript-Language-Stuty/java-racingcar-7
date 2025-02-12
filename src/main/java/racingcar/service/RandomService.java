package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomService {
    public boolean willCarMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
