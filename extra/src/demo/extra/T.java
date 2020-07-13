package demo.extra;

import com.sun.org.apache.bcel.internal.generic.LoadClass;

/**
 * @author zhaopeng
 * @create 2020-07-02 9:47
 */

public class T {

    static class Parent{
       public static int A=1;
       Parent(int a){

       }

       static{
           A=2;
       }
    }

    static class Sub extends Parent{
        public static int B=A;
        Sub(){
            super(1);
        }
    }

    public static void main(String[] args) {
        T t=new T();
        Class<? extends T> aClass = t.getClass();
        ClassLoader classLoader = aClass.getClassLoader();
    }

}


