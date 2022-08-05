import java.util.Scanner;

public class Main {

    static int result;

    static Scanner keyboard = new Scanner(System.in);




    public static String cacl(String input) {

        RomanNumbers[] roman = RomanNumbers.values();
        String[] arabianNumbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        int arabianCount = 0;
        int romanCount = 0;
        String[] array = input.split(" ");

        try {
            for (int i = 0; i < arabianNumbers.length; i++) {
                if (array[0].equals(arabianNumbers[i])) {
                    array[0] = arabianNumbers[i];
                    arabianCount++;
                }
            }

            for (int i = 0; i < arabianNumbers.length; i++) {
                if (array[2].equals(arabianNumbers[i])) {
                    array[2] = arabianNumbers[i];
                    arabianCount++;
                }
            }

            for (int i = 0; i < roman.length; i++) {
                if (array[0].equals(roman[i].toString())) {
                    array[0] = roman[i].getValue();
                    romanCount++;
                }
            }

            for (int i = 0; i < roman.length; i++) {
                if (array[2].equals(roman[i].toString())) {
                    array[2] = roman[i].getValue();
                    romanCount++;
                }
            }

            if(Integer.parseInt(array[0]) <= 0 || Integer.parseInt(array[0]) > 10 || Integer.parseInt(array[2]) <= 0 || Integer.parseInt(array[2]) > 10) {
                return "одно или оба числа меньше или равны 0 или больше 10!!!";
            }


                if ((arabianCount == 2) || (romanCount == 2)) {
                if (array[1].equals("+")) {
                    result = Integer.parseInt(array[0]) + Integer.parseInt(array[2]);
                }
                if (array[1].equals("-")) {
                    result = Integer.parseInt(array[0]) - Integer.parseInt(array[2]);
                }
                if (array[1].equals("*")) {
                    result = Integer.parseInt(array[0]) * Integer.parseInt(array[2]);
                }
                if (array[1].equals("/")) {
                    result = Integer.parseInt(array[0]) / Integer.parseInt(array[2]);
                }
                if (arabianCount == 2) {
                    return "Результат: " + result;
                } else {
                    for (int i = 0; i < roman.length; i++) {
                        if (result == Integer.parseInt(roman[i].getValue())) {
                            return "Результат: " + roman[i].toString();
                        }
                    }
                }
            }
            else {
                return "Оба числа должны быть или арабскими или римскими!!!";
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return "Ошибка ввода. Проверьте корректность вводимого выражения. \nТак же проверьте ставите ли вы пробелы между оператором и операндами.";
        }

        return "баба капа";
    }
    static String greet() {
        return ("Здравствуйте. Это калькулятор. Введите два числа от 1 до 10 и арифметический оператор между ними\n\"Допускается ввод как арабских чисел, так и римских");
    }

    public static void main(String[] args) {

        System.out.println(Main.greet());
        System.out.println("Ввод: ");
        String expression = keyboard.nextLine();
        System.out.println(Main.cacl(expression));

    }
}