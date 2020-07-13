package stack;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/**
 * @author zhaopeng
 * @create 2020-05-13 19:21
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 *
 * s = "3[a2[c]]", 返回 "accaccacc".
 *
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
public class Solution {
    public boolean isValid(String s) {
        boolean flag=false;
        if(s.trim().isEmpty()){
            return true;
        }
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            if(c=='('||c=='{'||c=='['){
                stack.push(c);
            }else if(c==')'||c=='}'||c==']'){
                if(stack.isEmpty()){
                    return false;
                }
                Character peek = stack.peek();
                switch (c){
                    case ')':
                    {
                        if(peek=='('){
                            flag=true;
                            stack.pop();
                            continue;
                        }
                        break;
                    }
                    case '}':
                    {
                        if(peek=='{'){
                            flag=true;
                            stack.pop();
                            continue;
                        }
                        break;
                    }
                    case ']':
                    {
                        if(peek=='['){
                            stack.pop();
                            flag=true;
                            continue;
                        }
                        break;
                    }
                }
                stack.push(c);
            }
        }
         System.err.println(stack);
        if(!stack.isEmpty()){
            flag=false;
        }
        return flag;
    }

    public int findTargetSumWays(int[] nums, int S) {
        return 1;
    }



    public String decodeString(String s) {
        //s = "3[ 2[c] ]", 返回 "accaccacc".
        Stack<Character> stack=new Stack<>();

        Map<String,String> map=new HashMap<>();

        String str="";
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(c>='0'&&c<='9') {
                str+=c;
            }else if(c=='['){
                   str+=c;
            }else if(c==']'){
                if(stack.peek()=='['&&!stack.isEmpty()){

                }
            }
        }
        return stack.toString();
    }

    public static void main(String[] args) {
        int a=-1;
        System.err.println(a+2);
        Solution solution=new Solution();
        solution.decodeString("adadasdas");
    }
}