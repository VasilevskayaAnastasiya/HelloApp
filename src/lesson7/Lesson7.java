package lesson7;

import java.util.Scanner;

public class Lesson7 {

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws MyException {
        while (true) {
            System.out.println("**********************");
            System.out.println("Выберите пункт меню: ");
            System.out.println("0 - Выход");
            System.out.println("1 - Самая длинная последовательность");
            System.out.println("2 - Перевод в римские цифры");
            System.out.println("**********************");

            if (!sc.hasNextInt()) throw new MyException("Exception: введите число для выбора пункта меню");

            int taskid = sc.nextInt();
            if (taskid == 0) {
                break;
            }
            selectTask(taskid);

        }
    }

    public static void selectTask(int task) throws MyException {
        switch (task) {
            case 1:
                System.out.println("Введите строку: ");
                String str = sc.next();
                longestSubs(str);
                break;
            case 2:
                System.out.println("Введите число: ");
                if (!sc.hasNextInt()) throw new MyException("Exception: введите число для выбора пункта меню");
                int num = sc.nextInt();
                IntToRoman(num);
                break;
            default:
                System.out.println("Ошибка: неверный пункт меню");
                break;
        }
    }

    /**
     * Найти в массиве самую длинную последовательность, состоящую из одинаковых элементов.
     * Вывести на экран количество элементов самой длиной последовательности и номер элемента,
     * который является ее началом.
     */
    public static void longestSubs(String str){
        int start = 0;
        int count = 1;
        int maxStart = 0;
        int length = 0;
        for (int i = 1; i < str.length(); i++) {
            if(str.charAt(i) == str.charAt(i-1)){
                count++;
            }else{
                if (count > length){
                    length = count;
                    maxStart = start;
                }
                count = 1;
                maxStart = i;
            }

        }

        System.out.println("Длина последовательности символа " + str.charAt(maxStart) + " равна " + length + " начинается с " + maxStart);
    }

    /**
     * Перевести натуральное число n > 0 в римскую систему.
     * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
     * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
     * Например: 23 = XXIII, 44 = XLIV, 100 = C
     */
    public static void IntToRoman(int num){
        var keys = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        var vals = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

        String convert = "";
        int key = 0;

        while(key < keys.length){
            while(num >= vals[key]){
                var d = num / vals[key];
                num = num % vals[key];
                for(int i=0; i<d; i++)
                    convert += keys[key];
            }
            key++;
        }

        System.out.println(convert);
    }
}
