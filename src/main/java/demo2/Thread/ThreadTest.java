package demo2.Thread;

public class ThreadTest {
  public static void main(String[] args) {
    //
      thread thread = new thread();
      thread.setName("he");
      thread.run();

      new Thread(new thread01());




  }
}


class thread extends Thread{

    @Override
    public void run(){

    System.out.println("\t"+getName());
    }

}

class thread01 implements  Runnable{
    @Override
    public void run(){

    System.out.println("thread01");
    }
}
