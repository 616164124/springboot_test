package Thread.day01;

public class TinkerWindowRunnable implements Runnable {
    private int index=0;
    private  final int max=50;


    @Override
    public void run(){
        while (index<=max) {
            System.out.println("name:" + Thread.currentThread().getName() + "号码" + (index++));

        }
    }
}
