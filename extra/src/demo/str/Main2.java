package demo.str;
/**
 * datas["flag","fla","fl"]
 *    最长的前缀为："fl"
 *    1110
 *    0011
 *    1101
 * @author zhaopeng
 * @create 2020-06-19 13:04
 */
public class Main2 {
    public static void main(String args[]) {
        Integer a=new Integer(1);
        Integer b=new Integer(1);
        System.err.println(a.equals(b));
    }

    public static int test(){
        int j=0;
        try {
            int i=1/0;
        }catch (Exception e){
            return j;
        }finally {
            j++;
           // return j;
        }
        return j;
    }
}
