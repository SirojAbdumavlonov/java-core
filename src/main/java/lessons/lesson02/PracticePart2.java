package lessons.lesson02;

import java.util.Random;
import java.util.Scanner;

public class PracticePart2 {
    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();

    public void swapNumbers(){
        //Обмен значений *
        //Пользователь вводит два числа. Поменяйте их местами и выведите результат.
        System.out.println("Введите первое число: ");
        int number1 = scanner.nextInt();

        System.out.println("Введите второе число: ");
        int number2 = scanner.nextInt();

        int temp = number1;
        number1 = number2;
        number2 = temp;

        System.out.println("Результат: ");
        System.out.println("Первое число = " + number1);
        System.out.println("Второе число = " + number2);
    }
    public void displayMultiplicationTable(){
        //Таблица умножения *
        //Программа позволяет вывести на экран таблицу умножения для разных случаев.
        System.out.println("Введите число для которого нужна вам таблица: ");
        int number = scanner.nextInt();

        for(int i = 1; i <= 10; i++){
            System.out.printf("%d * %d = %d\n", number, i, number * i);
        }
    }

    public void convertCurrency(){
        System.out.println("Введите сумму в долларах: ");
        double sumInUsd = scanner.nextDouble();

        int exchange = 12_500;
        double result = sumInUsd * exchange;
        System.out.println("result = " + result);
    }

    public void isEvenOrOddNumber(){
        System.out.println("Введите число: ");
        int number = scanner.nextInt();
        int remainder = number % 2;
        switch(remainder){
            case 0:
                System.out.println("Четное число");
                break;
            case 1:
                System.out.println("Нечетное число");
                break;
        }
    }

    public void showMaxNumber(){
        int maxNumber = 0;

        for (int i = 1; i <= 3; i++){
            System.out.printf("Введите число n%d: ", i);
            int number = scanner.nextInt();
            if(number > maxNumber){
                maxNumber = number;
            }
        }
        System.out.println("Maximum number = " + maxNumber);
    }
    public void useCalculator(){
        System.out.println("Введите первое число: ");
        int number1 = scanner.nextInt();

        System.out.println("Введите второе число: ");
        int number2 = scanner.nextInt();

        System.out.println("Выберите операцию (*, /, +, -): ");
        String operation = scanner.next();

        switch (operation){
            case "*":
                System.out.println(number1 * number2);
                break;
            case "/":
                System.out.println(number1 / number2);
                break;
            case "+":
                System.out.println(number1 + number2);
                break;
            case "-":
                System.out.println(number1 - number2);
                break;
            default:
                System.out.println("Неправильная операция");
        }
    }
    public void calculateAverageSum(){
        System.out.println("Сколько чисел вы хотите ввести: ");
        int number = scanner.nextInt();

        int[] numbers = new int[number];
        int sum = 0;
        System.out.println("Числа:");
        for(int i = 0; i < number; i++){
            numbers[i] = scanner.nextInt();
            sum += numbers[i];
        }
        double average = (double) sum / numbers.length;
        System.out.println("average = " + average);
    }

    public void searchingElement(){
        System.out.println("Сколько чисел вы хотите ввести: ");
        int number = scanner.nextInt();

        int[] numbers = new int[number];
        System.out.println("Числа:");
        for(int i = 0; i < number; i++){
            numbers[i] = scanner.nextInt();
        }

        System.out.println("Введмте число который вы хотите поискать: ");
        int searchingNumber = scanner.nextInt();

        for (int j : numbers) {
            if (j == searchingNumber) {
                System.out.println("Найдено");
            }
        }
        System.out.println("Такого числа нету");
    }

    public void findNumber(){
        int randomNumber = random.nextInt(11);
        int number;
        System.out.println("Рандомно число сгенерировано.");
        do {
            System.out.println("Введите число: ");
            number = scanner.nextInt();

            if (number == randomNumber) {
                System.out.println("Правильно, вы угадали!");
                break;
            } else {
                System.out.println("Попытайтесь еще раз!");
            }
        } while (randomNumber != number);
    }
}
