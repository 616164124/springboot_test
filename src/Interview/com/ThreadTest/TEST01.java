package ThreadTest;

import java.util.stream.Stream;

public class TEST01 {
    public static void main(String[] args) {

        Stream.of("cus1", "cus2").forEach((n) -> {
            new Thread(n) {
                public void run() {

                }
            }.start();
        });

    }

}

class cusumer implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "\t");
    }
}

class pro implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "\t");
    }
}

