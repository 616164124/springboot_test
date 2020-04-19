package Thread.day003;

public class Sychinizethis implements Runnable {

  @Override
  public void run() {}
}




class Synchronized {

  public static void main(String[] args) {
    Sychinizethis sychinizethis = new Sychinizethis();

    Thread thread1 = new Thread(sychinizethis, "one");
    Thread thread2 = new Thread(sychinizethis, "two");
    Thread thread3 = new Thread(sychinizethis, "three");
    thread1.start();
    thread2.start();
    thread3.start();
  }
}
