package ua.com.foxminded.main;

import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final String STOP = "stop";

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Input the text: ");
        String text = "";
        CharCounter charCounter = new CachedCharCounter(new UniqueCharCounter());
        while (!(text = in.nextLine()).equals(STOP)) {
            printResult(charCounter.countChars(text));
        }

    }

    private static void printResult(Map<Character, Long> chars) {
        chars.forEach((key, value) -> System.out.println(String.format("\"%c\" - %d", key, value)));
    }
}