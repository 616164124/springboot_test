package demo2;

import java.util.Random;

/** 产生随机数 */
public class Imp {

  public static void main(String[] args) {

      new Random().nextInt(10);//10之内的int数

      System.out.println(type.valueOf("A").op());
  }
}

enum type implements Role {
    A{
public String op(){

  return "a";
}

}, B{
    public String op(){

      return "b";
    }},
    C{
    public String op() {
      return "c";
    }
};

}

interface Role{
  String op();
}

