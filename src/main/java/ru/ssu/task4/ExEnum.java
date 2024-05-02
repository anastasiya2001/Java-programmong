package main.java.ru.ssu.task4;
import java.util.Random;

public class ExEnum {
    enum MyString {
        INSTANCE;
        
        private final StringBuilder stringBuilder = new StringBuilder();

        public void appendRandomString() {
            Random random = new Random();
            StringBuilder randomString = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                randomString.append((char) (random.nextInt(26) + 'a'));
            }
            stringBuilder.append(randomString.toString());
        }

        public String getString() {
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            MyString.INSTANCE.appendRandomString();
        }

        String finalString = MyString.INSTANCE.getString();
        System.out.println(finalString);

        long endTime = System.currentTimeMillis();
        System.out.println("Execution time: " + (endTime - startTime) + " milliseconds");
    }
}
