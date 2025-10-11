package lessons.lesson02;

import java.util.Scanner;

public class PracticePart1 {

    private final Scanner scanner = new Scanner(System.in);

    public void task1(){
        //Вывести числа от 1 до 100 (каждые 10 цифр в одну строку и каждую группу с новой строки).
        int counter = 1;
        for (int i = 1; i <= 10; i++) {

            for (int j = 1; j <= 10; j++) {
                System.out.print(counter + " ");
                counter++;
            }
            System.out.println();
        }
    }

    public void task2(){
        //Сумма чисел от 1 до N (ввод N с клавиатуры).
        System.out.println("Enter number from 1 to N: ");
        int number = scanner.nextInt();

        while(number < 1){
            System.out.println("Enter number from 1 to N: ");
            number = scanner.nextInt();
        }

        int sum = number * (number + 1) / 2;
        System.out.println(sum);
    }
    public void task3(){
        //Произведение чисел от 1 до N.
        System.out.println("Enter number from 1 to N: ");
        int number = scanner.nextInt();

        while(number < 1){
            System.out.println("Enter number from 1 to N: ");
            number = scanner.nextInt();
        }

        int total = 1;
        for (int i = 1; i <= number; i++) {
            total = total * i;
        }
        System.out.println(total);
    }

    public void task4(){
        //Сумма четных чисел от 1 до N.
        System.out.println("Enter number from 1 to N: ");
        int number = scanner.nextInt();

        while(number < 1){
            System.out.println("Enter number from 1 to N: ");
            number = scanner.nextInt();
        }

        int sum = 0;

        for (int i = 2; i <= number; i += 2) {
            sum += i;
        }

        System.out.println(sum);
    }

    public void task5(){
        //Сумма цифр числа (например, 1234 → 10).
        System.out.println("Enter number from 1 to N: ");
        int number = scanner.nextInt();

        while(number < 1){
            System.out.println("Enter number from 1 to N: ");
            number = scanner.nextInt();
        }

        int digitSum = 0;
        while(number >= 1){
            int remainder = number % 10;
            number = number / 10;
            digitSum += remainder;
        }
        System.out.println(digitSum);
    }

    public void task6(){
        System.out.println("Enter number from 1 to N: ");
        int number = scanner.nextInt();
        int result = 0;
        while(number != 0){
            int remainder = number % 10;
            number = number / 10;

            result = result * 10 + remainder;
        }
        System.out.println("result = " + result);
    }
    public void task7(){
        System.out.println("Enter number from 1 to N: ");
        int number = scanner.nextInt();

        while(number < 1){
            System.out.println("Enter number from 1 to N: ");
            number = scanner.nextInt();
        }

        int total = 1;
        for (int i = 1; i <= number; i++) {
            total = total * i;
        }
        System.out.println(total);
    }

    public void task8(){
        //Найти первое число, которое делится на 7 и больше 1000.
        int number = 1000;

        int remainder = number % 7;

        number = number + (7 - remainder);
        System.out.println(number);
    }

    public void task9(){
        //Вывести все простые числа до N.
        System.out.println("Enter number from 1 to N: ");
        int number = scanner.nextInt();

        while (number < 1){
            System.out.println("Enter number from 1 to N: ");
            number = scanner.nextInt();
        }

        for(int i = 2; i <= number; i++){
            if (isPrime(i)){
                System.out.println(i + " ");
            }
        }
    }
    public void task10(){
        //Нарисовать треугольники из звездочек:
        for (int count = 1; count <= 4; count++) {
            System.out.println("*".repeat(count));
        }

        System.out.println();

        for (int count = 4; count >= 1; count--) {
            System.out.println("*".repeat(count));
        }
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) { // достаточно проверять до sqrt(num)
            if (num % i == 0) return false;
        }
        return true;
    }


}
