package flashcards;

import java.util.LinkedList;

public class Logger {

    static LinkedList<String> logs = new LinkedList<>();

    public static void printAndLog(String text) {
        System.out.println(text);
        logs.add(text + "\n");
    }

    public static void log(String text) {
        logs.add(text + "\n");
    }

    public static String getLogsToString() {
        StringBuilder sb = new StringBuilder();
        logs.forEach(sb::append);
        return sb.toString();
    }

}

