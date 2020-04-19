package Thread.day01;


public class TinkerWindow  extends Thread {
    private  String name;
    private  int    Max=50;
    private  int    index = 1;

    public  TinkerWindow(String name){

        this.name=name;

    }

    public TinkerWindow() {

    }

    public  void run(){
        while (index<=Max){
            System.out.println("柜台"+name +"当前的号码"+(index++));

        }
    }


    }
