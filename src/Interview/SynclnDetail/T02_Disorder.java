package SynclnDetail;

/**
 * 证明线程的乱序执行 一旦x y 同时为0时说明发生乱序执行 （执行时间太长）
 */
public class T02_Disorder {
    private static int x, y, a, b;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for (; ; ) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            Thread thread2 = new Thread(() -> {
                a = 1;
                x = a;
            });

            Thread thread1 = new Thread(() -> {
                b = 1;
                y = b;
            });
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
            if (x == 0 || y == 0) {
                System.out.println("第" + i + "次出现" + "(" + x + "," + y + ")");
                break;
            }

        }
    }

}
