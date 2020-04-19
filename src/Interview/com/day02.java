import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 字符串中的大写小写分成两个字符串
 */
public class day02 {
    public static void main(String[] args) {
        String s = "jkkshfVAD";
        StringBuffer head = new StringBuffer();
        StringBuffer last = new StringBuffer();
        char[] chars=s.toCharArray();

        System.out.println(chars.length);
        for (int i =0;i<chars.length ;i++){
            if (chars[i]<='a'){
                head.append(chars[i]);
            }else {
                last.append(chars[i]);
            }
        }
        System.out.println(head.toString()+"\t\t\t"+last.toString());

    }

}
