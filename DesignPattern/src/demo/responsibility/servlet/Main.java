package demo.responsibility.servlet;
import java.util.ArrayList;
import java.util.List;
/**
 * 简单实现servlet的filter实现
 * @author zhaopeng
 * @create 2020-07-14 14:20
 */

public class Main {
    public static void main(String[] args) {
         Request request=new Request();
         Response response=new Response();
        Filter1 filter1=new Filter1();
        Filter2 filter2=new Filter2();
        FilterChain filterChain=new FilterChain();
        filterChain.add(filter1).add(filter2);
        filterChain.doFilter(request,response,filterChain);
    }

}

//定义filter接口
interface Filter{
   boolean doFilter(Request request, Response response,FilterChain filterChain);
}

//Request类
class Request{
    private String request;
    public String getRequest() {
        return request;
    }
    public void setRequest(String request) {
        this.request = request;
    }
}

//response类
class Response{
    private String Response;
    public String getResponse() {
        return Response;
    }
    public void setResponse(String response) {
        Response = response;
    }
}

//定义Filter1
class Filter1 implements Filter{
    @Override
    public boolean doFilter(Request request, Response response,FilterChain filterChain) {
        System.err.println("Filter1 do request....");
        filterChain.doFilter(request,response,filterChain);
        System.err.println("Filter1 do reponse....");
        return true;
    }
}


//定义Filter2
class Filter2 implements Filter{
    @Override
    public boolean doFilter(Request request, Response response,FilterChain filterChain) {
        System.err.println("Filter2 do request....");
        System.err.println("Filter2 do reponse....");
        return true;
    }
}



class FilterChain implements Filter{
    List<Filter> list=new ArrayList<>();
    //下标位置
    int index=0;
    public FilterChain add(Filter filter){
        list.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Request request, Response response,FilterChain filterChain) {
        if(index == list.size() ){
            return true;
        }
        Filter filter = list.get(index);
        index++;
        filter.doFilter(request,response,filterChain);
        return true;
    }
}
