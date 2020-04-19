package Thread.day002;

import java.util.Optional;

/**
 * setDaemon(booleam) 是守护线程
 */
public class DaemThread {

    public static void main(String[] args) {

        Thread thread = new Thread(()->{

           Thread innerThread =   new  Thread(()->{

               while (true){
                   System.out.println("innerthred running!!!!");
                   try {
                       Thread.sleep(1_000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }

            });
           innerThread.setDaemon(true);
           innerThread.start();
            System.out.println("inner start");
            try {
                Thread.sleep(20_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        System.out.println(Thread.currentThread().getName());
        Optional.of(Thread.currentThread().getName()+"hello").ifPresent(System.out::println);
    }

}
