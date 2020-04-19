package com.throwable;

/**
 * Demo class
 *
 * @author keriezhang
 * @date 2016/10/31
 */
public class ErrorTest {

    public static void main(String[] args) {
        try {
            test(); // 报错

        } catch (Exception e) {

            System.out.println("A");

        } finally {
            System.out.println("B");
        }
        //获得异常return也是返回finally{}中的 若没有则返回catch中的
        System.out.println(test1());


    }

    public static void test() {
        int a = 1 / 0;
        System.out.println(a);
    }

    public static int test1() {
        int a = 2;
        int b = 3;
        int c = 5;
        int error;
        try {
            error = a / 0; //报异常
            return a;
        } catch (Exception e) {
            return b;
        } finally {
            return c;
        }
    }

}

class MyException extends Exception {
    public MyException() {
        System.out.println("进入MyException（）");
    }

    public MyException(String str) {
        super(str);
    }
}