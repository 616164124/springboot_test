package SynclnDetail;

import com.Jdk8Features.User;
import org.openjdk.jol.info.ClassLayout;

public class T01 {
    public static void main(String[] args) {
        Object o = new Object();
        User user = new User();


        System.out.println(ClassLayout.parseInstance(o).toPrintable()); // 该对象占内存多少字节

        synchronized (o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());// synchronized 的信息在markword里（看value值前后变化）

        }
        add();

    }
    //锁消除
    //stringbuffer 为线程安全的，在append，append中加锁解锁，加锁解锁 但是jvm会判断sf 这个引用只会add这个方法中使用，不被其他线程引用(因为是局部变量，栈私有)
    //因此sf不可能为共享资源，从而jvm会自动消除stringbuffer对象内部的锁
    public static void add(){

        StringBuffer sf = new StringBuffer();
        sf.append("fsf").append("sf");

    }

}
