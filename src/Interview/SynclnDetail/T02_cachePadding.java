package SynclnDetail;

/**
 *
 * 与   T02_cacheLine 中的用时差别
 * 利用缓存行对齐的特性 ： 缓存行， 每一行为64字节，且cpu按缓存行处理数据 伪共享
 * 如 disruption框架
 *
 */

public class T02_cachePadding {
    private static class T01 {
        private volatile long p1, p2, p3, p4, p5, p6, p7;  // 一个long 为8 7个long共56 加上 x共64字节
    }

    private static class T02 extends T01 {
        private volatile long x = 0L;
    }

    public static T02[] t02 = new T02[2];

    static {
        t02[0] = new T02();
        t02[1] = new T02();
    }


    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            for (long i = 0; i < 10000_000L; i++) {
                t02[0].x = i;
            }
        });

        Thread thread2 = new Thread(() -> {
            for (long i = 0; i < 10000_000L; i++) {
                t02[0].x = i;
            }
        });
        final long l = System.nanoTime();
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println((System.nanoTime() - l) / 100_0000); // 用时在220左右

    }


}
