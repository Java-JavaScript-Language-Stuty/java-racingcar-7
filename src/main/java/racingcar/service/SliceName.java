package racingcar.service;

import java.util.Arrays;
import java.util.List;

public class SliceName {
    public static List<String> slice(String s) {
        return Arrays.asList(s.split(","));
    }
}
