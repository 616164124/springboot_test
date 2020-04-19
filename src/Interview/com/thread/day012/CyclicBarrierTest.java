package Thread.day012;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier (集齐七颗龙珠才能召唤神龙)
 */
public class CyclicBarrierTest {

  public static void main(String[] args) {


    CyclicBarrier cyclicBarrier =
        new CyclicBarrier(
            7,
            () -> {
              System.out.println("结束******"); // 等线程数为7的时候才执行
            });
    for (int i = 0; i <= 7; i++) {

      int a = i;
      new Thread(
              () -> {
                System.out.println(a);

                try {
                  cyclicBarrier.await();
                } catch (InterruptedException e) {
                  e.printStackTrace();
                } catch (BrokenBarrierException e) {
                  e.printStackTrace();
                }
              })
          .start();
    }
  }
}
