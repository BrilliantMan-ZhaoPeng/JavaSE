package demo.responsibility.base;
import java.util.ArrayList;
import java.util.List;
/**
 * 责任链模式实现
 * @author zhaopeng
 * @create 2020-07-14 11:33
 */
public class Main {
    public static void main(String[] args) {
        Msg msg=new Msg();
        msg.setContext("AA -- BB -- CC -- DD");
        AAFilter aaFilter=new AAFilter();
        BBFilter bbFilter=new BBFilter();


        FilterChain filterChain=new FilterChain();
        filterChain.addFilter(aaFilter).addFilter(bbFilter);
        filterChain.doFilter(msg);
        System.err.println(msg.getContext());
    }
}

//定义一个消息类
class Msg{
    private String context;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "context='" + context + '\'' +
                '}';
    }
}

//定义一个Filter接口
interface Filter{
  boolean doFilter(Msg msg);
}

//将 AA--->aa
class AAFilter implements Filter{
    @Override
    public boolean doFilter(Msg msg) {
        msg.setContext(msg.toString().replace("AA","aa"));
        return false;//执行到这里之后的所有都不会执行
    }
}

//执行到这里后面的所有能执行
class BBFilter implements Filter{
    @Override
    public boolean doFilter(Msg msg) {
        msg.setContext(msg.toString().replace("BB","bb"));
        return true;
    }
}



class CCFilter implements Filter{
    @Override
    public boolean  doFilter(Msg msg) {
        msg.setContext(msg.toString().replace("BB","bb"));
        return true;
    }
}


//直接将AAFilter与BBFilter集成为一个FilterChain(过滤链条)     AAFilter->BBFilter 形成了一个链
class FilterChain implements Filter{
    List<Filter> list=new ArrayList<>();
    //添加Filter   细节得很
    public FilterChain addFilter(Filter filter){
        list.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Msg msg) {
        for (Filter filter : list) {
            //遇到flase直接退出
            if(!filter.doFilter(msg)){
                return false;
            }
        }
        return true;
    }
}