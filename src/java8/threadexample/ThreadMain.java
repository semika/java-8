package java8.threadexample;

public class ThreadMain {

    public static void main(String args[]) {

        //Annonyous class
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("This is runnable thread");
            }
        };

        Runnable runnable1 = () -> System.out.println("This is runnable thread");

        Thread thread = new Thread(runnable1);
        thread.start();
    }
}
