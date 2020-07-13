package com.zp.demo.xor;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.Stack;

/**
 * 统计字符串字母，数字，空格和其他字符个数
 * @author zhaopeng
 * @create 2020-06-21 9:45
 */
public class Main4 {

    public static void main(String[] args) {
        int one = getOne(3);
        System.err.println(one);
    }

    public static int getOne(int data){
              int count=0;
              while(data!=0){
                  data=data&(data-1);
                  count++;
              }
              return count;
    }

    //质数定义为在大于1的自然数中，除了1和它本身以外不再有其他因数
    public static  boolean match(int data){
        if(data<0||data%2==0&&data!=2){
             return false;
        }
        for (int i = 2; i <= Math.sqrt(data) ; i++) {
            if(data%i==0){
                return false;
            }
        }
        return true;
    }

    //123  321
    public static int  re(int data){
        long res=0;
        while(data!=0){
            res=res*10+data%10;
            data/=10;
            if(res<Integer.MIN_VALUE||res>Integer.MAX_VALUE){
               return 0;
            }
        }
        return (int)res;
    }


    //123  321
    public static int  re2(int data){
        return Integer.reverse(data);
    }


    public static boolean  test(String str){
        String trim = str.trim();
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < trim.length(); i++) {
            char c = trim.charAt(i);
            stack.push(c);
        }
        for (int i = 0; i < trim.length(); i++) {
            char c = trim.charAt(i);
            if(c!=stack.pop()){
                return false;
            }
        }
        return true;
    }



    public static void match(String str){
        int zimu=0;
        int shuzi=0;
        int kongge=0;
        int otger=0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c>='a'&&c<='z'||c>='A'&&c<='Z'){
               zimu++;
            }else if(c>='0'&&c<='9'){
               shuzi++;
            }else if(c==' '){
                kongge++;
            }else{
                otger++;
            }
        }
        System.err.println("zimu:"+zimu+" shuzi:"+shuzi+" kongge:"+kongge+" otger:"+otger);
    }
}
