package racingcar.util;

import java.util.regex.Pattern;

public class Validator {
    public static boolean isNumber(String arg){
        if(arg == null || !arg.matches("\\d+")) return false;
        return true;
    }
}
