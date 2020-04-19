import java.util.Arrays;
import java.util.stream.IntStream;

public class test1 {

  public static void main(String[] args) {
    int[] shuzu = new int[100];
    IntStream.range(1, 100)
        .forEach(
            n -> {
              shuzu[n] = n;
            });

   // System.out.println(Arrays.toString(shuzu));

    int[] shuzu2 = new int[10];

    IntStream.range(1, 10)
        .forEach(
            n -> {
              if (n == 7) {
                System.out.println(n);
              }
            });
  }
}
