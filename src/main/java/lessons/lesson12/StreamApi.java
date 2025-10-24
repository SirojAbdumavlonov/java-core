package lessons.lesson12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamApi {
    public void task1() {
        //Оставь только чётные и выведи их квадраты.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        numbers.stream().filter(number -> number % 2 == 0)
            .map(number -> number * number)
            .forEach(System.out::println);

        System.out.println();

        for (Integer number : numbers) {
            if (number % 2 == 0) {
                number *= number;
                System.out.println(number);
            }
        }
    }
    public void task2() {
        //Подсчитай, сколько строк в списке длиннее 5 символов.
        List<String> words = List.of("apple", "banana", "pear", "pineapple");

        words.stream().filter(word -> word.length() >= 5).forEach(System.out::println);

        for (String word : words) {
            if (word.length() >= 5) {
                System.out.println(word);
            }
        }
    }

    public void task3() {
        //Найди максимальное и минимальное число в списке с помощью Stream API.
        List<Integer> nums = List.of(10, 2, 33, 4, 25);

        int max = nums.stream()
            .max(Comparator.naturalOrder())
            .get();
        System.out.println("max = " + max);

        int min = nums.stream()
            .min(Comparator.naturalOrder())
            .get();
        System.out.println("min = " + min);

        int maxNumber = 0;
        int minNumber = 0;

        for (Integer num : nums) {
            if (num > maxNumber) {
                maxNumber = num;
            }
        }
        for (Integer num : nums) {
            if (num < minNumber) {
                minNumber = num;
            }
        }
        System.out.println("maxNumber = " + maxNumber);
        System.out.println("minNumber = " + minNumber);
    }

    public void task4() {
        //Посчитай среднюю длину строк в списке.
        List<String> names = List.of("Alice", "Bob", "Charlie", "David");

        double average = names.stream()
            .mapToInt(String::length)
            .average()
            .orElse(0.0);

        System.out.println("average = " + average);
        
        int totalSum = 0;
        for (String name : names) {
            totalSum += name.length();
        }
        average = (double) totalSum / names.size();
        System.out.println("average = " + average);
    }

    public void task5() {
        //Удали дубликаты и отсортируй строки по длине.
        List<String> input = List.of("apple", "pear", "apple", "banana", "pear");

        List<String> uniqueStrings = input.stream()
            .distinct()
            .sorted(Comparator.comparingInt(String::length))
            .toList();
        System.out.println("uniqueStrings = " + uniqueStrings);

        Set<String> uniqueSetWords = new HashSet<>(input);
        List<String> uniqueWords = new ArrayList<>(uniqueSetWords);
        uniqueWords.sort(Comparator.comparingInt(String::length));
        System.out.println("uniqueWords = " + uniqueWords);
    }

    public void task6() {
        //Преобразуй список строк в Map: ключ — строка, значение — длина.
        List<String> fruits = List.of("apple", "banana", "kiwi");

        Map<String, Integer> map = fruits.stream()
            .collect(Collectors.toMap(
                s -> s,
                String::length
            ));
        System.out.println("map = " + map);

        Map<String, Integer> forMap = new HashMap<>();

        for (String fruit : fruits) {
            forMap.put(fruit, fruit.length());
        }
        System.out.println("forMap = " + forMap);
    }

    public void task7() {
        //Сгруппируй имена по первой букве.
        List<String> names = List.of("Alice", "Andrew", "Bob", "Charlie", "Catherine");

        Map<Character, List<String>> groupedNames = names.stream()
            .collect(Collectors.groupingBy(s -> s.charAt(0)));

        System.out.println("groupedNames = " + groupedNames);
    }

    public void task8() {
        //Собери список имён в одну строку через запятую.
        List<String> names = List.of("Tom", "Jerry", "Spike");

        String oneLine = String.join(" ", names);
        System.out.println("oneLine = " + oneLine);
    }

    public void task9() {
        //Из списка предложений получить список всех слов.
        List<String> sentences = List.of("Java is cool", "Streams are powerful");

        List<String> allWords = sentences.stream()
            .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
            .toList();
        System.out.println("allWords = " + allWords);
    }

    public void task10() {
        //Найди самый дорогой продукт в каждой категории.
        List<Product> products = List.of(
        new Product("Phone", "Electronics", 1200),
        new Product("TV", "Electronics", 1800),
        new Product("Apple", "Fruits", 2.5),
        new Product("Mango", "Fruits", 4.0));

        Map<String, Product> mappedProducts = products.stream()
            .collect(Collectors.toMap(
                product -> product.category,
                Function.identity(), //object itself becomes a value
                BinaryOperator.maxBy(Comparator.comparingDouble(Product::price))));

        System.out.println("mappedProducts = " + mappedProducts);

        Map<String, Product> forProducts = new HashMap<>();

        for (Product product : products) {
            if (forProducts.containsKey(product.category)) {
                Product foundProduct = forProducts.get(product.category);
                if (product.price() > foundProduct.price()) {
                    forProducts.remove(foundProduct.category);
                    forProducts.put(product.category, product);
                }
            } else {
                forProducts.put(product.category, product);
            }
        }
        System.out.println("forProducts = " + forProducts);
    }

    record Product(String name, String category, double price) {}

}