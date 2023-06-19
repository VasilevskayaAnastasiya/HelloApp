package lesson14;

public class task1 {
    public static void main(String[] args) {

        for (int i = 1; i < 6; i++) {

//            Philosopher ph = new Philosopher();
//            ph.setName("Философ"+String.valueOf(i));
//            ph.start();
            Thread t = new Thread(new Philosopher());
            t.setName(String.valueOf(i));
            t.start();
        }
    }
}

class Philosopher extends Thread {
    public void run() {
        // кол-во приемов пищи
        var num = 0;
        while (num < 3) {// пока количество приемов пищи не достигнет 3
            philosopherEat();
            num++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("у философа " + Thread.currentThread().getName() + " проблемы со здоровьем");
            }
        }

    }

    //применим оператор synchronized к методу eating()
    synchronized public void philosopherEat() {

        try {
            System.out.println(Thread.currentThread().getName() + " садится за стол");
            // философ ест
            Thread.sleep(1000);

            System.out.println(Thread.currentThread().getName() + " выходит из-за стола");

        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " ошибка");
        }
    }
}