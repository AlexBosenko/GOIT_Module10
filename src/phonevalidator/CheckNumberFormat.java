package phonevalidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckNumberFormat {
    private static final String REG_WITH_BRACKET = "^\\(\\d{3}\\)\\s\\d{3}\\-\\d{4}$";
    private static final String REG_WITHOUT_BRACKET = "^\\d{3}\\-\\d{3}\\-\\d{4}$";

    public boolean numberIsValid(String number) {
        return (numberInFormat(number, REG_WITH_BRACKET) ||
                numberInFormat(number, REG_WITHOUT_BRACKET));
    }

    private static boolean numberInFormat(String number, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        if (matcher.find()) {
            return true;
        }
        return false;
    }
}
