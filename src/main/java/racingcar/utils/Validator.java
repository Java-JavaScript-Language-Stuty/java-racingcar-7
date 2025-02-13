package racingcar.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static void stringRangeCheck(String input, int min, int max) {
        if (input.length() <= min || input.length() > max) {
            throw new IllegalArgumentException("[Error] Invalid character length.");
        }
    }

    public static <T> void duplicationCheck(List<T> itemList) {
        Set<T> uniqueNames = new HashSet<>(itemList);
        if (uniqueNames.size() != itemList.size()) {
            throw new IllegalArgumentException("[Error] Duplicated.");
        }
    }

    public static void naturalNumberCheck(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("[Error] Invalid number.");
        }
    }
}
