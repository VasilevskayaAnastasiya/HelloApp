import java.util.Scanner;
public class Lesson2 extends Main{
    public static void lesson2(){
        while (true) {
            System.out.println("**********************");
            System.out.println("Выберите пункт меню: ");
            System.out.println("0 - Выход");
            System.out.println("1 - Тип треугольника");
            System.out.println("2 - Постфикс для возраста");
            System.out.println("**********************");
            if (sc.hasNextInt()) {
                int taskid = sc.nextInt();
                if (taskid == 0) {
                    break;
                }
                selectTask(taskid);
            }else{
                sc.nextLine(); //как-то сбросить то, что уже ввел пользователь...
                System.out.println(ANSI_RED + "Ошибка: введите число для выбора пункта меню" + ANSI_RESET);
            }
        }
    }

    public static void selectTask(int task) {
        switch (task) {
            case 1:
                System.out.println("Введите через пробел стороны треугольника: ");
                String a = sc.next();
                String b = sc.next();
                String c = sc.next();

                if(!isNumeric(a) || !isNumeric(b) || !isNumeric(c)){
                    System.out.println(ANSI_RED + "Ошибка: введено не число" + ANSI_RESET);
                    selectTask(1);
                }
                TypeTriangle(Double.parseDouble(a), Double.parseDouble(b), Double.parseDouble(c));
                break;
            case 2:
                System.out.println("Введите возраст");
                if (sc.hasNextInt()) {
                    int age = sc.nextInt();
                    PostfixOld(age);
                }else{
                    String test = sc.nextLine();
                    System.out.println(ANSI_RED + "Ошибка: введено не число ("+test+")" + ANSI_RESET);
                    selectTask(2);
                }
                break;
            default:
                System.out.println(ANSI_RED + "Ошибка: неверный пункт меню" + ANSI_RESET);
                break;
        }
    }

    /**
     * Простая (2 балла)
     *
     * Треугольник задан длинами своих сторон a, b, c.
     * Проверить тип треугольника
     */
    public static void TypeTriangle(double a, double b, double c){

        if(a+b<c && a+c<b && b+c<a){
            System.out.println(ANSI_RED + "Ошибка: по сторонам нельзя составить треугольник" + ANSI_RESET);
            selectTask(1);
        }
        double sigCosA = b * b + c * c - a * a;
        double sigCosB = c * c + a * a - b * b;
        double sigCosC = a * a + b * b - c * c;

        if (sigCosA < 0 || sigCosB < 0 || sigCosC < 0)
            System.out.println(ANSI_BLUE + "Треугольник является тупоугольным" + ANSI_RESET);
        else if (sigCosA == 0 || sigCosB == 0 || sigCosC == 0)
            System.out.println(ANSI_BLUE + "Треугольник является прямоугольным" + ANSI_RESET);
        else
            System.out.println(ANSI_BLUE + "Треугольник является остроугольным" + ANSI_RESET);
    }

    /**
     * Простая (2 балла)
     *
     * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
     * вернуть строку вида: «21 год», «32 года», «12 лет».
     */
    public static void PostfixOld(int age){
        String postfix = "";
        int  last = age % 10;
        boolean isExclusion = (age % 100 >= 11) && (age % 100 <= 14);

        if (last == 1)
            postfix = "год";
        else if(last == 0 || last >= 5 && last <= 9)
            postfix = "лет";
        else if(last >= 2 && last <= 4)
            postfix = "года";
        if (isExclusion)
            postfix = "лет";

        System.out.println(ANSI_BLUE + age + " " + postfix + ANSI_RESET);
    }

    public static boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }
}
