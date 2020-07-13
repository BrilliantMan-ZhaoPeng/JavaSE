package demo.singleton;
/**
 * 饿汉的实现
 * @author zhaopeng
 * @create 2020-05-23 22:41
 */
public class Singleton1{

    private static final Singleton1 INSTANCE=new Singleton1();

    private  Singleton1(){

    }

    public static synchronized Singleton1 getInstance(){
           return INSTANCE;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
              new Thread(()->{
                  Singleton1 singleton1=Singleton1.getInstance();
                  System.err.println(singleton1.hashCode());
              }).start();
        }
    }
}