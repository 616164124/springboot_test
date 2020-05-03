package SynclnDetail;

import java.util.concurrent.TimeUnit;

public class T01HelloVolatile {
    volatile boolean flag = true; //对比下有误volatile的输出情况

    void m() {
        System.out.println("m start");
        while (flag) {
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {

        T01HelloVolatile t = new T01HelloVolatile();

        new Thread(t::m, "t1").start();    //函数式接口 t::m

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.flag = false;

    }


}
