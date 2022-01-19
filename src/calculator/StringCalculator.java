package calculator;

import java.util.regex.*;

public class StringCalculator {
    int add(String text) {
        if (text == null || text.isEmpty()) return 0;
        
        int sum = 0;
        String delimeter = ",|:";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(m.find()) {
            delimeter += "|"+m.group(1);
            text = m.group(2);
        }
        for(String number : splitNumbers(text, delimeter)) {
            sum += changeNumbers(number);
        }
        
        return sum;
    }
    private int changeNumbers(String number) {
        int num = Integer.parseInt(number);
        if (num < 0) {
            throw new RuntimeException("input negative number!");
        }
        return num;
    }
    private String[] splitNumbers(String text, String delimeter) {
        String[] numbers = text.split(delimeter);
        return numbers;
    }
}
