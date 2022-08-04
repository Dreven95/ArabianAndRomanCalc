package com.dreven95.calculator;
import java.util.Scanner;

public class Calculator {

    int result;
    String expression = "";

    Scanner keyboard = new Scanner(System.in);

    void greet() {
        System.out.println("Здравствуйте. Это калькулятор. Введите два числа от 1 до 10 и арифметический оператор между ними");
        System.out.println("Допускается ввод как арабских чисел, так и римских");
    }

    void calculation() {
        RomanNumbers[] roman = RomanNumbers.values();
        String arabianNumbers[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        int arabianCount = 0;
        int romanCount = 0;
        String romanAnswer = " ";
        System.out.println("Ввод: ");
        this.expression = keyboard.nextLine();
        String[] array = this.expression.split(" ");

        try {
            for(int i = 0; i < arabianNumbers.length; i++) {
                if(array[0].equals(arabianNumbers[i])) {
                    array[0] = arabianNumbers[i];
                    arabianCount++;
                }
            }

            for(int i = 0; i < arabianNumbers.length; i++) {
                if(array[2].equals(arabianNumbers[i])) {
                    array[2] = arabianNumbers[i];
                    arabianCount++;
                }
            }

            for(int i = 0; i < roman.length; i++) {
                if(array[0].equals(roman[i].toString())) {
                    array[0] = roman[i].getValue();
                    romanCount++;
                }
            }

            for(int i = 0; i < roman.length; i++) {
                if(array[2].equals(roman[i].toString())) {
                    array[2] = roman[i].getValue();
                    romanCount++;
                }
            }

            if(Integer.parseInt(array[0]) <= 0 || Integer.parseInt(array[0]) > 10 || Integer.parseInt(array[2]) <= 0 || Integer.parseInt(array[2]) > 10)

            if((arabianCount == 2) || (romanCount == 2)) {
                if(array[1].equals("+")) {
                    result = Integer.parseInt(array[0]) + Integer.parseInt(array[2]);
                }
                if(array[1].equals("-")) {
                    result = Integer.parseInt(array[0]) - Integer.parseInt(array[2]);
                }
                if(array[1].equals("*")) {
                    result = Integer.parseInt(array[0]) * Integer.parseInt(array[2]);
                }
                if(array[1].equals("/")) {
                    result = Integer.parseInt(array[0]) / Integer.parseInt(array[2]);
                }
                if(arabianCount == 2) {
                    System.out.println("Результат " + result);
                }
                else {
                    for(int i = 0; i < roman.length; i++) {
                        if(result == Integer.parseInt(roman[i].getValue())) {
                            System.out.println("Результат " + roman[i].toString());
                        }
                    }
                }
            }
            else {
                System.out.println("Оба числа должны быть или арабскими или римскими!!!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ставьте пробелы между оператором и операндами!!!");
        }

    }


    public static void main(String[] args) {

        Calculator calc = new Calculator();
        calc.greet();
        calc.calculation();

    }
}
