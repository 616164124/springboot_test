package com.thread;

/**
 * "abcdef" "123456" 两个数组 输出“a1b2c3d4”
 */
public class T01_00_cas {
    // 不使用volatile 时，会造成死锁
    static volatile ReadytoRun t = ReadytoRun.t1;

    public static void main(String[] args) {


        char[] chars = "abcdef".toCharArray();
        char[] chars1 = "123456".toCharArray();


        new Thread(() -> {
            for (char c : chars) {
                while (t != ReadytoRun.t1) {
                }
                System.out.println(c);
                t = ReadytoRun.t2;

            }
        }, "b").start();
        new Thread(() -> {
            for (char c : chars1) {
                while (t != ReadytoRun.t2) {
                }
                System.out.println(c);
                t = ReadytoRun.t1;

            }
        }, "a").start();


    }

    enum ReadytoRun {t1, t2}
}
