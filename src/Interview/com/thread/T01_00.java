package com.thread;

/**
 * "abcdef" "123456" 两个数组 输出“a1b2c3d4”
 */
public class T01_00 {

    // 不使用volatile 时，会造成死锁
    static volatile ReadytoRun t = ReadytoRun.t1;

    public static void main(String[] args) {
        char[] chars = "abcdef".toCharArray();
        char[] chars1 = "123456".toCharArray();
        String s=null;

        new Thread(() -> {
            for (char c : chars) {
                while (t != ReadytoRun.t1) {
                }

                System.out.print(c);
                t = ReadytoRun.t2;
            }
        }, "b").start();
        new Thread(() -> {
            for (char c : chars1) {
                while (t != ReadytoRun.t2) {
                }
                System.out.print(c);
                t = ReadytoRun.t1;

            }
        }, "a").start();

    }

}
enum ReadytoRun {t1, t2}