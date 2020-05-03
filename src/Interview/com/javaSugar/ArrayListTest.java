package com.javaSugar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Administrator
 * <p>
 * <p>
 * Arrays.asList("1", "123");执行add 时报错 ,且foreach 进行删除时也会报错
 * 要先进行Iterator 或者将list转化成strem的形式进行lambda格式过滤
 *
 *
 */
public class ArrayListTest {
    public static void main(String[] args) {
        aVoid();
        Add();
        bVoid();
        cVoid();
    }

    //报错 UnsupportedOperationException
    public static void Add() {
        List<String> list = Arrays.asList("1", "232", "sfsf");
        list.add("ter");

    }

    //不会报错
    public static void aVoid() {
        List<String> list = new ArrayList<>(Arrays.asList("1", "123"));
        list.add("34343");
        //将“1” 移除
        list.removeIf(str->str.equals("1"));
        System.out.println(list);
    }

    public static void bVoid(){
        List<String> list = Arrays.asList("1", "232", "sfsf");

        list.stream().filter(a -> a.equals("232")).forEach(list::remove);
        System.out.println(list);
    }
    public static void cVoid(){
        List<String> strings = new ArrayList<>();
        strings.add("123");
        strings.add("sfe");
        strings.add("4564");
        Iterator<String> stringIterator = strings.iterator();
        //去掉"sfe"
        Stream<String> stringStream = strings.stream().filter(a -> !a.equals("sfe"));
        stringStream.forEach(a->System.out.println(a));


    }
}
