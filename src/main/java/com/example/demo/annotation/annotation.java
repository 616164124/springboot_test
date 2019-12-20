package com.example.demo.annotation;


import javax.naming.Name;

@myAnnotation(name = "hua",age = 23)
public class annotation {

    private String  Name;

    private  int age;

    public void setName(String name) {
        Name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "annotation{" +
                "Name='" + Name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return age;
    }

}


class AnnotationTest{

    public static void main(String[] args) {

        annotation  annotation = new annotation();
        System.out.println(annotation);
    }







}
