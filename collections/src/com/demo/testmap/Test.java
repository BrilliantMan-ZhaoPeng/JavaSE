package com.demo.testmap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhaopeng
 * @create 2020-06-22 8:31
 */

public class Test {
   static class Student{
        private int age;
        private String name;

        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }

       @Override
       public boolean equals(Object obj) {
            Student s=(Student)obj;
            return  this.age==s.age&&this.name.equals(s.name);
       }

       @Override
       public int hashCode() {
           return this.name.hashCode()+age;
       }
   }

    public static void main(String[] args) {
        Student t1=new Student(1,"zhangsan");
        Student t2=new Student(1,"zhangsan");
        System.err.println(t1.equals(t2));
        System.err.println(t1.hashCode()==t2.hashCode());
    }

}
