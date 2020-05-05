package SynclnDetail;

/**
 * threadLocal 只跟当前线程有关
 */

public class T03_ThreadLocal {


    static ThreadLocal<User> userThreadLocal = new ThreadLocal<User>();

    public static void main(String[] args) {

        new Thread(()->{
            System.out.println(userThreadLocal.get());  // 将userThreadLocal 作为一个key塞入threalocalmap中，而这个key作为弱引用指向 ThreadLocal
        }).start();

        new Thread(()->{
             userThreadLocal.set(new User("hua", 12));
        }).start();

    }

}
class User{
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;
    private  int age;

}