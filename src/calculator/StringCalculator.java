package calculator;

import java.util.regex.*;

public class StringCalculator {
    int add(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        
        int sum = 0;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(m.find()) {
            String customDelimeter = m.group(1);
            String[] tokens = m.group(2).split(customDelimeter);
            for(String token : tokens) {
                String[] numbers = token.split(",|:");
                
                for(String number : numbers) {
                    int num = Integer.parseInt(number);
                    if (num < 0) {
                        throw new RuntimeException("input negative number!");
                    } else {
                        sum += num;
                    }
                }
            } 
        }
        else {
            String[] numbers = text.split(",|:");
            for(String number : numbers) {
                int num = Integer.parseInt(number);
                    if (num < 0) {
                        throw new RuntimeException("input negative number!");
                    } else {
                        sum += num;
                    }
            }
        }
        
        return sum;
    }
}
