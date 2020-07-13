package demo.str;
import java.util.Arrays;
/**
 * 输⼊: ["flower","flow","flight"]
 * 输出: ["fl"]
 * @author zhaopeng
 * @create 2020-06-29 9:46
 */
public class Main3 {
    public static void main(String[] args) {
        String[] strs={"flower","flow","flight"};
        sort(strs);
        print(strs);
    }

    public static void sort(String[] strs){
        Arrays.sort(strs);
    }


    public static void print(String[] strs){
        for (String str : strs) {
            System.err.print(str+" ");
        }
    }

}

