package Lesson9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lesson9 {

    public static void main(String[] args) {
        String str = "";
//        try {
//            str = "Хлеб 39.9; Молоко 62; Курица 184.0; Конфеты 89.9";
//            expensiveProduct(str);
//        } catch (MyException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try {
//            str = "Хлеб 39.9;Молоко 62;Курица 184.0;Конфеты 89.9";
//            expensiveProduct(str);
//
//        } catch (MyException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try {
//            str = "Хлеб 39.9; Молоко 62; Курица 184.0; Конфеты 899.9;";
//            expensiveProduct(str);
//
//        } catch (MyException e) {
//            System.out.println(e.getMessage());
//        }

        try {
            str = "2 + 31 - 40 + 13";
            sum(str);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            str = "2 + 31 -- 40 + 13";
            sum(str);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            str = "2 + 31 - 40 34 + 13";
            sum(str);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /*
     * Сложная (6 баллов)
     *
     * Строка содержит названия товаров и цены на них в формате вида
     * "Хлеб 39.9; Молоко 62; Курица 184.0; Конфеты 89.9".
     * То есть, название товара отделено от цены пробелом,
     * а цена отделена от названия следующего товара точкой с запятой и пробелом.
     * Вернуть название самого дорогого товара в списке (в примере это Курица),
     * или пустую строку при нарушении формата строки.
     * Все цены должны быть больше нуля либо равны нулю.
     * В случае неверной строки выкинуть свое исключение.
     */
    public static void expensiveProduct(String str) throws MyException {
        String pattern = "([а-яА-Я]+\\s\\d+\\.?\\d*)+(;\\s[а-яА-я]+\\s\\d+\\.?\\d*)*;?";
        if (!str.matches(pattern)) {
            throw new MyException("Не верный формат строки");
        }
        String[] strArray = str.split(";");
        double maxCost = 0;
        String maxProduct = "";
        for (String s : strArray) {
            String[] product = s.trim().split(" ");
            if (Double.parseDouble(product[1]) > maxCost) {
                maxCost = Double.parseDouble(product[1]);
                maxProduct = product[0];
            }
        }

        System.out.println("Самый дорогой товар " + maxProduct + " по цене " + maxCost);
    }

    /*
     * Сложная (6 баллов)
     *
     * В строке представлено выражение вида "2 + 31 - 40 + 13",
     * использующее целые положительные числа, плюсы и минусы, разделённые пробелами.
     * Наличие двух знаков подряд "13 + + 10" или двух чисел подряд "1 2" не допускается.
     * Вернуть значение выражения (6 для примера).
     * Про нарушении формата входной строки бросить исключение IllegalArgumentException
     */
    public static void sum(String str) throws IllegalArgumentException {
        String patternFormat = "(\\d+(\\s[+\\-]\\s\\d+)*)";
        if (!str.matches(patternFormat)) {
            throw new IllegalArgumentException("Не верный формат строки");
        }

        Pattern pattern = Pattern.compile("(([+\\-]?)\\s?(\\d+))");
        Matcher matcher = pattern.matcher(str);
        int sum = 0;
        while (matcher.find()) {
            String action = matcher.group(2);
            int number = Integer.parseInt(matcher.group(3));

            if (action.equals("+")) {
                sum += number;
            } else if (action.equals("-")) {
                sum -= number;
            } else {
                sum = number;
            }
        }
        System.out.println(str + " = " + sum);
    }
}
