package SynclnDetail;

/**
 * 两个线程都对 volatile的sum进行操作
 */
public class T02_cacheLine {
     private static class  T {
         private volatile  long  sum = 0L;
     }
     public static T[] arr= new T[2];
     static {
         arr[0] = new T();
         arr[1] = new T();
     }

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(()->{
            for (long i = 0; i < 10000_000L; i++) {
                arr[0].sum=i;
            }
        });

        Thread thread2 = new Thread(()->{
            for (long i = 0; i < 10000_000L; i++) {
                arr[1].sum=i;
            }
        });
        final long l = System.nanoTime();
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println((System.nanoTime()-l)/100_0000); //用时在400左右

    }

}
