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
        String[] texts = text.split(",");
        
        return texts;
    }
    private int[] toInteger(String[] texts) {
        int[] numbers = new int[texts.length];
        for(int i=0; i<numbers.length; i++) {
            numbers[i] = Integer.parseInt(texts[i]);
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
