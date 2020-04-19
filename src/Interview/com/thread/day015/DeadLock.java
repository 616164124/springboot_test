package Thread.day015;

import java.util.concurrent.TimeUnit;


/**
 * 死锁
 */
public class DeadLock implements Runnable {
    private String locka;
    private String lockb;

    public DeadLock(String locka, String lockb) {
        this.locka = locka;
        this.lockb = lockb;
    }

    @Override
    public void run() {
        synchronized (locka) {
            System.out.println(Thread.currentThread().getName() + "\t 持有" + locka + "\t 获取" + lockb);
            try {
                TimeUnit.SECONDS.sleep(123);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockb) {
                System.out.println(Thread.currentThread().getName() + "\t 持有" + lockb + "\t 获取" + locka);
            }
        }
    }
}


class testDeadLocek {

    public static void main(String[] args) {
        String locka = "locka";
        String lockb = "lockb";

        new Thread(new DeadLock(locka, lockb), "aaa").start();
        new Thread(new DeadLock(lockb, locka), "bbbb").start();
        /*
        new Thread(() -> {
            new DeadLock(locka, lockb).run();
        }, "AAA").start();

        new Thread(() -> {
            new DeadLock(lockb, locka).run();
        }, "BBB").start();*/


    }


}


