package com.Annotations;

import java.lang.annotation.*;

/**
 * 注解
 * 参考网址：https://blog.csdn.net/ThinkWon/article/details/100178709
 * 注解的作用:
 * 生成文档，通过代码里标识的元数据生成javadoc文档。
 * 编译检查，通过代码里标识的元数据让编译器在编译期间进行检查验证。
 * 编译时动态处理，编译时通过代码里标识的元数据动态处理，例如动态生成代码。
 * 运行时动态处理，运行时通过代码里标识的元数据动态处理，例如使用反射注入实例
 *
 */


public class AnnotationsTest {
    public static void main(String[] args) {
        Annotation[] annotation = Man.class.getAnnotations();
        System.out.println(annotation.length);
        Persons annotation1 =(Persons) annotation[0];
         for(Person person :annotation1.value()){
             System.out.println(person.role());
         }

    }
}





/**
 * @author Administrator
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Persons{
        Person[] value();
}

@Repeatable(Persons.class)
@interface Person{
    String role() default "";
}

@Person(role = "ceo")
@Person(role = "cto")
@Person(role = "coo")
@Person(role = "son")
 class Man{
String name;
}



