package demo.str;
/*
 * 将字符串中的空格 ab as gf as替换成66
 * 结果为:ab66as66gf66as
 *
 * @author zhaopeng
 * @create 2020-06-19 11:03
 */
public class Main {

    public static String method1(String str){
       return str.replaceAll("\\s","66");
    }

    public static String method2(String str){
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            //当遇到空串的时候
            if(" ".equals(String.valueOf(c))){
               stringBuilder.append("66");
            }else{
               stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
           String str="ab as gf as";
           System.err.println(method2(str));
    }
}
