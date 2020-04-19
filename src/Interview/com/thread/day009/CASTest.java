package Thread.day009;
/**
 * AtomicReference 使用 （类似于乐观锁）
 */

import java.util.concurrent.atomic.AtomicReference;

class User {

  int age;

  String name;

    public User(int age, String name) {
        this.age=age;
        this.name=name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

public class CASTest {

  public static void main(String[] args) {
    User user3 = new User(1, "z3");
    User user4 = new User(2, "l4");

    AtomicReference<User> userAtomicReference = new AtomicReference<>();
    userAtomicReference.set(user3);

    System.out.println(
        userAtomicReference.compareAndSet(user3, user4)
            + "\t"
            + userAtomicReference.get().getName());


  }
}
