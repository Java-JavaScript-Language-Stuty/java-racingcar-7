package racingcar.service;

import java.util.List;
import java.util.regex.Pattern;

public class CheckInput {
    public static List<String> checkName(String s) {
        if (s.isEmpty()) throw new IllegalArgumentException("자동차 이름들이 비어있습니다.");

        if (s.split(",").length < 2) throw new IllegalArgumentException("자동차 이름이 부족하거나 구분자가 없습니다.");

        List<String> l = SliceName.slice(s);

        for (String p : l) {
            if (Pattern.matches("\\s+", p)) throw new IllegalArgumentException("자동차 이름이 비어있습니다.");
            if (p.length() > 5) throw new IllegalArgumentException("자동차 이름이 5자 초과입니다.");
        }

        return l;
    }

    public static int checkNumber(String s) {
        if (s.isEmpty()) throw new IllegalArgumentException("횟수값이 비어있습니다.");

        try {
            Integer.parseInt(s);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("횟수값이 숫자가 아니거나 너무 많습니다.");
        }

        if (Integer.parseInt(s) <= 0) throw new IllegalArgumentException("횟수값이 양수가 아닙니다.");

        return Integer.parseInt(s);
    }
}
