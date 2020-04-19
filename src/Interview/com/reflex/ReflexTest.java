package com.reflex;

/**
 * 反射获取方法
 */
public class ReflexTest {


    public static void main(String[] args)throws ClassNotFoundException {
        //方法一  会抛出 ClassNotFoundException 的异常
        Class aClass = Class.forName("com.reflex.Book");
        //方法二
        Class  bClass = Book.class;
        //方法三
        Book book= new Book();
        Class<? extends Book> aClass1 = book.getClass();

        //返回都为true
        System.out.println( aClass==bClass);
        System.out.println(bClass==aClass1);



    }


}


class Book{
    public Book(){}
    private String name;
    private  String author;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
