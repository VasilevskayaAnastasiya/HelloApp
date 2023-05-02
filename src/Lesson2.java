import java.util.Scanner;
public class Lesson2 extends Main{
    public static void lesson2(){
        while (true) {
            System.out.println("**********************");
            System.out.println("Выберите пункт меню: ");
            System.out.println("0 - Выход");
            System.out.println("1 - Тип треугольника");
            System.out.println("2 - Постфикс для возраста");
            System.out.println("3 - Вписывается ли одна окружность в другую");
            System.out.println("4 - Счастливое число");
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
            case 3:

                System.out.println("Введите координаты центра первой окружности: ");
                String x1 = sc.next();
                String y1 = sc.next();

                System.out.println("Введите радиус первой окружности: ");
                String r1 = sc.next();

                System.out.println("Введите координаты центра второй окружности: ");
                String x2 = sc.next();
                String y2 = sc.next();

                System.out.println("Введите радиус второй окружности: ");
                String r2 = sc.next();

                if(!isNumeric(x1) || !isNumeric(y1) || !isNumeric(x2) || !isNumeric(y2) || !isNumeric(r2) || !isNumeric(r2)){
                    System.out.println(ANSI_RED + "Ошибка: введено не число" + ANSI_RESET);
                    selectTask(3);
                }

                double dx1 = Double.parseDouble(x1);
                double dy1 = Double.parseDouble(y1);
                double dr1 = Double.parseDouble(r1);
                double dx2 = Double.parseDouble(x2);
                double dy2 = Double.parseDouble(y2);
                double dr2 = Double.parseDouble(r2);

                circleInCircle(dx1, dy1, dr1, dx2, dy2, dr2);

                break;
            case 4:
                System.out.println("Введите четырехзначное число: ");
                if (sc.hasNextInt()) {
                    int num = sc.nextInt();
                    if(num < 1000 || num > 9999 ){
                        System.out.println(ANSI_RED + "Ошибка: введено не четырехзначное число ("+num+")" + ANSI_RESET);
                        selectTask(4);
                    }
                    isNumberHappy(num);
                }else{
                    String test = sc.nextLine();
                    System.out.println(ANSI_RED + "Ошибка: введено не число ("+test+")" + ANSI_RESET);
                    selectTask(4);
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

    /**
     * Простая (2 балла)
     *
     * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
     * окружности с центром в (x2, y2) и радиусом r2.
     */
    public static void circleInCircle(double x1, double y1, double r1, double x2, double y2, double r2){
        if((Math.pow((x2-x1), 2)+Math.pow((y2-y1), 2)) < Math.pow((r2-r1), 2)){
            System.out.println(ANSI_BLUE + "Первая окружность лежит во второй" + ANSI_RESET);
        }else{
            System.out.println(ANSI_BLUE + "Первая окружность НЕ лежит во второй" + ANSI_RESET);
        }
    }

    /**
     * Простая (2 балла)
     *
     * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
     * Определить, счастливое ли заданное число
     */
    public static void isNumberHappy(int num){
        int digits[] = new int[4];
        int i=0;
        while(i<4){
            digits[i] = num%10;
            num = num/10;
            i++;
        }

        if(digits[0]+digits[1] == digits[2]+digits[3]){
            System.out.println(ANSI_BLUE + "Число счастливое" + ANSI_RESET);
        }else{
            System.out.println(ANSI_BLUE + "Число НЕ счастливое" + ANSI_RESET);
        }
    }

    public static boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }
}
