package lessons.lesson12;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        StreamApi streamApi = new StreamApi();
        FunctionalInterface functionalInterface = new FunctionalInterface();

        List<String> words11 = new ArrayList<>();
        words11.add("hello");
        words11.add("world");

        Predicate<String> predicate11 = s -> s.startsWith("w");

        List<String> filteredWords11 = functionalInterface.task11Filter(words11, predicate11);

        System.out.println("filteredWords11 = " + filteredWords11);

        List<String> words12 = new ArrayList<>();
        words12.add("new task");
        words12.add("for me");

        Function<String, Integer> function12 = String::length;

        List<Integer> task12Lengths =
            functionalInterface.task12Map(words12, function12);

        System.out.println("task12Lengths = " + task12Lengths);

        List<String> words13 = new ArrayList<>();

        words13.add("Okay,");
        words13.add("people");
        words13.add("good day");

        Consumer<String> consumer13 = System.out::println;

        functionalInterface.task13ForEach(words13, consumer13);
    }
}