package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomService {
    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 9;
    private static final int THRESHOLD = 4;

    public boolean willCarMove() {
        return Randoms.pickNumberInRange(LOWER_BOUND, UPPER_BOUND) >= THRESHOLD;
    }
}
