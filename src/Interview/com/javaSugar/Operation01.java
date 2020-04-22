package com.javaSugar;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Operation01 {

    public static void main(String[] args) {
        int a =3;
        int b = 3;
        System.out.println(a<<b);
        int h ;
        Float F=0.75f;
        System.out.println(F);
        Object v = null;

        //输出为：true
        System.out.println( 0.1+1000 == 1000.1);
        // 输出 为 ：false
        System.out.println(3*0.1 == 0.3 );
        HashMap<Object, Object> hashMap = new HashMap<>();

        //去重
        char[] ch="sffsafa".toCharArray();
        HashSet<Object> ob = new HashSet<>();
        for(char c:ch){
            ob.add(c);
        }
        System.out.println(ob);

        char[] cA="abcdef".toCharArray();
        char[] cN="123456".toCharArray();
        Lock lock = new ReentrantLock();




    }
}
