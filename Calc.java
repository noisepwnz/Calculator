import java.util.Scanner;

public class Calc {

    static Scanner scanner = new Scanner(System.in); // cоздаем класс сканер
    static int number1, number2; // создаем переменные number1 , number2
    static char operation; // создаем переменную операция
    static int result; // создаем переменную результ
    static String sample1 = "\\s*(C|XC|XL|L?X{0,3})(IX|IV|V?I{0,3})\\s*\\W\\s*(C|XC|XL|L?X{0,3})(IX|IV|V?I{0,3})\\s*"; // дальше мой пример с римскими цифрами должен соответсвовать этому шаблону
    static String sample2 = "\\s*(\\d{1,2})\\s*\\W\\s*(\\d{1,2})\\s*";  // // дальше мой пример с арабскими цифрами должен соответсвовать этому шаблону


    public static void main(String[] args) throws RomeArithmeticException, IllegalArgumentException {

        System.out.println("введите арифметический пример арабскими или римскими цифрами от 1 до 10.");
        String userInputNumber = scanner.nextLine(); // Выведет что мы введем

        char[] chars = userInputNumber.toCharArray();  // мы разбиваем  userInputNumber на симводы и складываем их в массив.
        for (int i = 0; i < chars.length; i++) {    //  инициализируем i = 0, если i меньше чем длина массива chars , то делай i++
            chars[i] = userInputNumber.charAt(i);     /// первая итерация chars 0 = то что мы ввели в userInputNumber с
            // индексом 0, теперь в массиве чарс есть наше первое число, ифы не срабатывают потому что там нет знака идем по новой.
            // вторая итерация chars 1 = 1,   1 < 3 (потому что у нас выражение из 3 символов) , да меньше, значит доавь
            // этот символ в массив char , тут сработает какой то иф и мы выйдем с цикла.
            if (chars[i] == '+') operation = '+';
            if (chars[i] == '-') operation = '-';
            if (chars[i] == '*') operation = '*';
            if (chars[i] == '/') operation = '/';
        }


        if (userInputNumber.matches(sample1)) {  // мы говорим что если userInputNumber.matches(соответсвует sample1)
            String s = userInputNumber.replaceAll("\\s", "");  // меняет пробелы на "" , это похволяет делать пробелы в выражении с романскими цифрами
            String[] subStr = s.split("\\W"); // создаем массив subStr и говорим что он равен String s разделенную по любому символу
            // кроме букв

            String s1 = subStr[0];   // / s1 = subStr по индексу 0
            String s2 = subStr[1];      // s2 = subStr по индексу 0
            RomeNumber rn1 = RomeNumber.valueOf(s1);  // Енам RomeNumber с названием r1 = массиву s1 , в котором содержится то что мы ввели в консоль под индексом 0 - тоесть 1 число
            RomeNumber rn2 = RomeNumber.valueOf(s2);  // Енам RomeNumber с названием r1 = массиву s1 , в котором содержится то что мы ввели в консоль под индексом 0 - тоесть  2 число
            number1 = rn1.getNum();
            number2 = rn2.getNum();


            if (number1 == 0 || number2 == 0 || number1 > 10 || number2 > 10) {    // если выполнняются эти условия - выводи ошибку
                throw new IllegalArgumentException("Введены некоректные данные");
            }else {
                result = calculatedRoman(number1, number2, operation);  // если условия не выполняются
                System.out.println(RomeNumber.values() [result-1] + " " + "(" + result + ")"); //  - 1 потому что в массиве енам индекс на 1 больш тк с 0 идет

            }
        } else if (userInputNumber.matches(sample2)) {   // мы говорим что если userInputNumber.matches(соответсвует sample2)
            String s = userInputNumber.replaceAll("\\s", "");
            String[] subStr = s.split("\\W");
            number1 = Integer.valueOf(subStr[0]);
            number2 = Integer.valueOf(subStr[1]);
            if (number1 == 0 || number2 == 0 || number1 > 10 || number2 > 10) {
                throw new IllegalArgumentException("Введены некоректные данные");
            } else {
                result = calculatedArabian(number1, number2, operation);
                System.out.println(result);
            }

        } else {
            throw new IllegalArgumentException("Введены некоректные данные");

        }

    }

    public static int calculatedRoman(int number1, int number2, char operation) throws RomeArithmeticException {

        switch (operation) {
            case '+' -> result = number1 + number2;
            case '-' -> {
                if (number2 >= number1) {
                    throw new RomeArithmeticException("Результат вычисления римских чисел не может быть меньше 1");
                }
                result = number1 - number2;
            }
            case '*' -> result = number1 * number2;
            case '/' -> {
                if (number2 > number1) {
                    throw new RomeArithmeticException("Результат вычисления римских чисел не может быть меньше 1");
                }
                result = number1 / number2;
            }
        }
        return result;
    }

    public static int calculatedArabian(int number1, int number2, char operation) {

        switch (operation) {
            case '+' -> result = number1 + number2;
            case '-' -> result = number1 - number2;
            case '*' -> result = number1 * number2;
            case '/' -> result = number1 / number2;
        }
        return result;
    }

}
