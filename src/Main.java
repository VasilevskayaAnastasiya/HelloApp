// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.


import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        while (true) {
            System.out.println("**********************");
            System.out.println("Выберите пункт меню: ");
            System.out.println("0 - Выход");
            System.out.println("1 - Число наоброт");
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
                System.out.println("Введите число больше 0: ");
                if (sc.hasNextInt()) {
                    int num = sc.nextInt();
                    taskIntRevert(num);
                }else{
                    String test = sc.nextLine();
                    System.out.println(ANSI_RED + "Ошибка: введено не число ("+test+")" + ANSI_RESET);
                    selectTask(1);
                }
                break;
            default:
                System.out.println(ANSI_RED + "Ошибка: неверный пункт меню" + ANSI_RESET);
                break;
        }
    }

    public static void taskIntRevert(int num){
        if(num < 0){
            System.out.println(ANSI_RED + "Ошибка: число меньше 0" + ANSI_RESET);
            selectTask(1);
        }else if(num < 10){
            System.out.println(ANSI_BLUE + "Число наоборот: " + num + ANSI_RESET);
        }else{
            int result = calcRevertNum(num, 0);
            System.out.println(ANSI_BLUE + "Число наоборот: " + result + ANSI_RESET);
        }
    }
    public static int calcRevertNum(int num, int revertnum) {
        int mod = num % 10;
        int i = num / 10;
        if (i >= 10) {
            return calcRevertNum(i, (revertnum + mod) * 10);
        } else {
            return (revertnum + mod) * 10 + i;
        }
    }
}