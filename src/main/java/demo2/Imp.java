package demo2;

/** 产生随机数 */
public class Imp {

  public static void main(String[] args) {

    int i = 0, random;

    while (true) {
      i++;
      random = (int) (Math.random() * 1000);

      if (random < 10) {
        System.out.println("中奖了!!!");
        break;
      }
    }
  }
}
