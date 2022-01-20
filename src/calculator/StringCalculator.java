package calculator;

import java.util.regex.*;

public class StringCalculator {
    public int add(String text) {
        if (isBlank(text)) return 0;
        
        return sum(toInteger(split(text)));
    }
    private boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }
    private String[] split(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimeter = m.group(1);
            return m.group(2).split(customDelimeter);
        }
        
        return text.split(",|:");
    }
    private int toPositive(String text) {
        int number = Integer.parseInt(text);
        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }
    private int[] toInteger(String[] texts) {
        int[] numbers = new int[texts.length];
        for(int i=0; i<numbers.length; i++) {
            numbers[i] = toPositive(texts[i]);
        }
        return numbers;
    }
    private int sum(int[] numbers) {
        int res = 0;
        for(int number : numbers) {
            res += number;
        }
        return res;
    }
}
