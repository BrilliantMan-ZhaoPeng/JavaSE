package demo.extra;
/**
 * @author zhaopeng
 * @create 2020-06-28 22:16
 */
public class MergeUser {

    public static class User{
        public String a;
        public String b;
        public String c;
        User(String a,String b,String c){
            this.a=a;
            this.b=b;
            this.c=c;
        }
    }

    //如果两个user的a字段一样，或者b字段一样，或者c字段一样，就认为是一人
    //请合并users.返回合并之后的用户数量
    public static int mergeUser(User[] user){

           return 100;
    }


}
