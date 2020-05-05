package SynclnDetail;

import java.util.Arrays;

public class T03_SplitString {
    public static void main(String[] args) {
        String s = "0:first sf ,1:one ones ,2:two sfs";
        Arrays.stream(s.split(",")).forEach((str)-> System.out.println(str));

    }
}
