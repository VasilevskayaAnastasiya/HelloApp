public class Lesson3 extends Main{
    public static void lesson3(){
        while (true) {
            System.out.println("**********************");
            System.out.println("Выберите пункт меню: ");
            System.out.println("0 - Выход");
            System.out.println("1 - Тип треугольника");
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
}
