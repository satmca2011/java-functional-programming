package lambda;

class ThreadDemo implements Runnable{

    @Override
    public void run() {
        System.out.println("run() method starts.....");
    }
}
public class LamdaForRunnable {
    public static void main(String[] args) {
        System.out.println("Traditional way:");
        Thread t1 = new Thread(new ThreadDemo());
        t1.start();

        System.out.println("Using Lambda:");
        Runnable runnable = () -> {System.out.println("Lambda -> run() method starts.....");};
        Thread t2 = new Thread(runnable);
        t2.start();
    }
}
