package Thread.day004;

import java.util.stream.Stream;

/**
 * 多个生产者多个消费者情况:
 */

public class Sychnozie2 {

  private final Object LOCK = new Object();
  private volatile boolean isProduce = false;
  private int i = 0;

  public void produce() {

    synchronized (LOCK) {
      while (isProduce) {
        try {
          LOCK.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      i = i + 1;
      System.out.println("p->>" + Thread.currentThread().getName() + "    " + i);
      LOCK.notifyAll();
      isProduce = true;
    }
  }

  public void comsume() {
    synchronized (LOCK) {
      while (!isProduce) {
        try {
          LOCK.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      System.out.println("c->>" + Thread.currentThread().getName() + "    " + i);
      LOCK.notifyAll();
      isProduce = false;
    }
  }
}

class Sychronize2test {

  public static void main(String[] args) {
    Sychnozie2 sychinzie = new Sychnozie2();
    Stream.of("p1", "p2")
        .forEach(
            n -> {
              new Thread(n) {
                @Override
                public void run() {
                  while (true) sychinzie.produce();
                }
              }.start();
            });

    Stream.of("c1", "c2")
        .forEach(
            n -> {
              new Thread(n) {
                @Override
                public void run() {
                  while (true) sychinzie.comsume();
                }
              }.start();
            });
  }
}
