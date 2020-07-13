package binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaopeng
 * @create 2020-06-23 22:50
 */
public class Solution2 {
    public static class Employee{
        public int happy;
        public List<Employee> nexts;
        public Employee(int h) {
             happy=h;
             nexts=new ArrayList<>();
        }
    }

    public static class Info{
        //来的时候
        public int yes;
        //不来的时候
        public int no;

        public Info(int y,int n) {
            yes=y;
            n=no;
        }
    }

    public static Info process(Employee e){
        if(e.nexts.isEmpty()){
           return new Info(e.happy,0);
        }
        //来就获取
        int yes=e.happy;
        //不来就不获取
        int no=0;

        for (Employee next : e.nexts) {
            Info process = process(next);
            yes+=process.no;
            no+=Math.max(process.yes,process.no);
        }
        return new Info(yes,no);
    }
}
