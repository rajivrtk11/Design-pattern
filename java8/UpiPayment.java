package java8;

import java.text.SimpleDateFormat;

@FunctionalInterface
public interface UpiPayment {
    String doPayment(String src, String dest);

    static SimpleDateFormat datePattern(String patterns) {
        return new SimpleDateFormat(patterns);
    }
}
