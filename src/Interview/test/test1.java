package test;

import java.util.concurrent.TimeUnit;

public class test1 {

    volatile boolean flag = true;


    public static void main(String[] args) {
        test1 test1 = new test1();

        new Thread(test1::m, "test1 p").start();

        long t = 23;

        test1.n();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        test1.flag = false;


    }
    void m() {
        System.out.println("m start");
        while (flag) {
        }
        System.out.println("m end");

    }
    void  n(){
        System.out.println("n()");
    }


}
