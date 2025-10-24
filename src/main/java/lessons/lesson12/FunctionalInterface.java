package lessons.lesson12;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalInterface {
    public void task1(){
//        Создай Predicate<String>, который проверяет, что строка не пуста и длиннее 3 символов.
        Predicate<String> predicate = s -> s.length() > 3;
        predicate.test("b");
        predicate.test("Hello");
    }
    public void task2(){
//        Создай Function<String, Integer>, возвращающую длину строки.
        Function<String, Integer> function = String::length;
        function.apply("Hello");
    }
    public void task3(){
        //Создай Supplier<UUID>, который возвращает новый UUID при каждом вызове.
        Supplier<UUID> supplier = UUID::randomUUID;
        supplier.get();
    }
    public void task4(){
        //Создай Consumer<String>, который выводит строку в upper case.
        Consumer<String> consumer = str -> System.out.println(str.toUpperCase());
        consumer.accept("Hello");
    }
    public void task5(){
        //Создай BiFunction<Integer, Integer, Integer>, которая возвращает сумму двух чисел.
        BiFunction<Integer, Integer, Integer> biFunction = Integer::sum;
        biFunction.apply(1, 2);
    }
    public void task6(){
        //Function<String, String> trim и Function<String, String> toUpperCase.
        // Объедини их в одну, которая сначала обрезает пробелы, потом делает верхний регистр.

        Function<String, String> trim =  String::trim;
        Function<String, String> toUpperCase = String::toUpperCase;

        Function<String, String> combined = trim.andThen(toUpperCase);

        String result = combined.apply(" Hello ");
    }
    public void task7(){
        //Один Consumer печатает строку в консоль,
        // второй — печатает длину строки. Объедини их через andThen().
        Consumer<String> consumer = System.out::println;
        Consumer<String> length = s -> System.out.println(s.length());

        Consumer<String> combined = consumer.andThen(length);
        combined.accept("Hello");
    }
    public void task8(){
        //Создай Predicate<Integer> isEven и isPositive.
        // Получи Predicate, который проверяет "нечётное или отрицательное".
        Predicate<Integer> isEven = i -> i % 2 == 0;
        Predicate<Integer> isPositive = i -> i > 0;

        Predicate<Integer> combined = isEven.negate().and(isPositive.and(isPositive));
        combined.test(17);
        combined.test(11);
        combined.test(15);
    }
    public void task9(){
        //BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        // Function<Integer, String> toStr = x -> "Result: " + x; Используй andThen(), чтобы объединить в одну цепочку.
        BiFunction<Integer, Integer, Integer> multiply = (i, j) -> i * j;
        Function<Integer, String> toStr = x -> "Result: " + x;

        BiFunction<Integer, Integer, String> combined = multiply.andThen(toStr);

        String result = combined.apply(15, 15);
    }
    public void task10(){
        //Создай UnaryOperator<String>, который добавляет "!!!" к строке.
        UnaryOperator<String> operator = s -> s + "!!!";
        String result = operator.apply("Hello");
        System.out.println("result = " + result);
    }
    public <T> List<T> task11Filter(List<T> list, Predicate<T> predicate){
        return list.stream()
            .filter(predicate)
            .toList();
    }

    public <T, R> List<R> task12Map(List<T> list, Function<T, R> function){
        return list.stream()
            .map(function)
            .toList();
    }
    public <T> void task13ForEach(List<T> list, Consumer<T> consumer){
        list.forEach(consumer);
    }
    public <T> List<T> task14Generate(Supplier<T> supplier, int n){
        List<T> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(supplier.get());
        }
        return list;
    }
}