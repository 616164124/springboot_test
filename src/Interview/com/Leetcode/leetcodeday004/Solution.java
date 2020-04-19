package Leetcode.leetcodeday004;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * 第 7 题
 * 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * <p>
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * <p>
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * <p>
 */

public class Solution {
    public static void main(String[] args) {
        int i =Integer.MAX_VALUE;
        long test1start = System.currentTimeMillis();
       // test1(i);
        long test1end = System.currentTimeMillis();
        System.out.println(test1end - test1start+"用时 test1");

        long test2start = System.currentTimeMillis();
        System.out.println(test2(i));
        long test2end = System.currentTimeMillis();
        System.out.println(test2end - test2start+"用时 test2");

    }

    //方法一失败末位为0时不对
    public static long test1(int i) {
        String is = String.valueOf(i);
        StringBuffer stringBuffer = new StringBuffer(is);
        stringBuffer.reverse();
        String is1 = stringBuffer + "";
        return Integer.valueOf(is1);
    }
    //方法二
    public static int test2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }



}
