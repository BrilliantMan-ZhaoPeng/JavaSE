package demo.str;
import java.util.*;
/**
 * @author zhaopeng
 * @create 2020-06-29 16:47
 */

public class Solution {
   /* 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
    示例 1:
    输入: "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

    示例 2:
    输入: "bbbbb"
    输出: 1
    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

    示例 3:
    输入: "pwwkew"
    输出: 3
    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
                 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。*/
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==1||s.trim().equals(" ")){
            return 1;
        }
        int maxCount=0;
        for (int i = 0; i < s.length(); i++) {
            Map<Character,Integer> map=new HashMap();
            int count=0;
            for (int j = i; j < s.length() ; j++) {
                char c = s.charAt(j);
               //  System.err.println(set.contains(c));
                if(map.containsKey(c)){
                    break;
                }
                count++;
                maxCount=maxCount>count ?maxCount:count;
                map.put(c,1);
            }
        }
        return maxCount;
    }
    public int lengthOfLongestSubstring2(String s) {
        int maxCount=0;
        Set<Character> set=new HashSet<>();
        int left=0;
        int right=-1;
        for (int i = 0; i < s.length(); i++) {
            if(i!=0){
                set.remove(s.charAt(i-1));
            }
            while(right+1<s.length() && !set.contains(s.charAt(right+1))){
               set.add(s.charAt(right+1));
               right++;
            }
          //  System.err.println(right);
            maxCount=Math.max(maxCount,right+1-i);
        }
        return maxCount;
    }
    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * 示例 1：
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     *
     * 输入: "cbbd"
     * 输出: "bb"
     */
    public String longestPalindrome(String s) {
        if(s.length()==1){
            return s;
        }

        String str="";
        int maxCount=0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb=new StringBuilder();
            for (int j = i; j < s.length() ; j++) {
                //判断i~j是否是回文
                sb.append(s.charAt(j));
                boolean flag=true;
                for (int k = i; k <= (i+j)/2 ; k++) {
                   if(s.charAt(k)!=s.charAt(j+i-k)){
                       flag=false;
                       break;
                   }
                }
               System.err.println(s.charAt(i)+":flag:"+flag);
               if(flag){
                   int temp=maxCount;
                   maxCount=Math.max(maxCount,j-i+1);
                   if(temp!=maxCount){
                     str=sb.toString();
                   }
               }
                System.err.println("str--"+str);
           }
       }
       return str;
    }


    /**
     * 给你两个二进制字符串，返回它们的和（用二进制表示）。
     * 输入为 非空 字符串且只包含数字 1 和 0。
     * 示例 1:
     * 输入: a = "11", b = "1"
     * 输出: "100"
     *
     * 示例 2:
     * 输入: a = "1010", b = "1011"
     * 输出: "10101"
     */
    public String addBinary(String a, String b) {
        int curr=0;
        int max = Math.max(a.length(), b.length());
        StringBuilder sb=new StringBuilder();
        for (int i = max-1; i >=0 ; i--) {
            curr += i>=a.length() ? 0:a.charAt(i)-'0';
            curr += i>=b.length() ? 0:b.charAt(i)-'0';
            sb.append(curr%2);
            curr/=2;
        }
        if(curr==1){
            sb.append(curr);
        }
        StringBuilder reverse = sb.reverse();
        return reverse.toString();
    }


    /**
     * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
     *
     * 示例:
     *
     * 输入: 38
     * 输出: 2
     * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
     */
    public int addDigits(int num) {
        int temp=0;
        while(true){
            while(num>0){
                temp += num%10;
                num/=10;
            }
            if(temp>=0&&temp<10){
                break;
            }
            num=temp;
            temp=0;
        }
        return temp;
    }


    /**
     * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
     * 注意：
     *
     * num1 和num2 的长度都小于 5100.
     * num1 和num2 都只包含数字 0-9.
     * num1 和num2 都不包含任何前导零。
     * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
     */
    public String addStrings(String num1, String num2) {
        int max = Math.max(num1.length(), num2.length());
        //进位
        int curr=0;
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < max; i++) {
            int x = i<=num1.length()-1 ? num1.charAt(num1.length()-1-i)-'0':0;
            int y = i<=num2.length()-1 ? num2.charAt(num2.length()-1-i)-'0':0;
            sb.append((x+y+curr)%10);
            curr=(x+y+curr)/10;
        }
        if(curr==1){
             sb.append("1");
        }
        return sb.reverse().toString();
    }


    /**
     * 假如有两个字符串，s1="people"和s2="eplm"，我们要求他俩最长的公共子串。
     * 我们一眼就能看出他们的最长公共子串是"pl"，长度是2。但如果字符串特别长的话就不容易那么观察了。
     */
    public  int maxLong(String str1, String str2) {
        int max=0;
        int[][] res=new int[str1.length()+1][str1.length()+1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    res[i][j]=res[i-1][j-1]+1;
                }else{
                    res[i][j]=0;
                }
                max=Math.max(res[i][j],max);
            }
        }
        return max;
    }


    /**
     * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
     *
     * 示例 1:
     *
     * 输入: "(()"
     * 输出: 2
     * 解释: 最长有效括号子串为 "()"
     * 示例 2:
     *
     * 输入: ")()())"
     * 输出: 4
     * 解释: 最长有效括号子串为 "()()"
     */


    //    ()(()

    /**
     *
     * -1     0
     * 0
     *
     *
     *
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {//(
                stack.push(i);
            } else {//  )  可以与前面进行匹配
                 stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }


    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * 示例 1:
     *
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     *
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     *
     * 所有输入只包含小写字母 a-z 。
     */


    //暴力
    public String longestCommonPrefix(String[] strs) {
        String res="";

        if(strs.length==0){
           return res;
        }

        int minLength=strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            minLength=Math.min(strs[i].length(),minLength);
        }
   //     System.err.println("minLength:"+minLength);
        for (int i = 1; i <= minLength; i++) {
            boolean flag=false;
            String str = strs[0];
            String substring = str.substring(0, i);
            for (int j = 1; j < strs.length; j++) {
                //匹配上了就继续匹配
                if(!substring.equals(strs[j].substring(0,i))){
                    flag=true;
                    break;
                }
            }
            if(flag){
                 break;
            }
            res=substring;
        }
        return res;
    }


    //trie的方式

    //建立Node节点
    class Node{
        private int pass; //当前节点经过了多少次
        private int end;//是否是结束
        private Character ch;
        private Map<Character,Node> nexts;//
        public Node(int pass, int end,Character ch) {
            this.pass = pass;
            this.end = end;
            this.nexts = new HashMap<>();
            this.ch=ch;
        }
    }

    private Node root=new Node(0,0, null);

    public void insert(String str){
        Node temp=root;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Map<Character, Node> nexts = temp.nexts;
            char ch=chars[i];
            if(nexts.get(ch)==null){//如果当前节点没有当前的节点
                nexts.put(ch,new Node(0,0,ch));
            }
            temp=nexts.get(ch);
            temp.pass++;
        }
        temp.end++;
    }

    public boolean contains(String str){
        Node curr=root;
        if(str.length()==0||str.trim().equals("")){
            return false;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            Map<Character, Node> nexts = curr.nexts;
            if(nexts.get(ch)==null){
                return false;
            }
            curr=nexts.get(ch);
        }
        return curr.end!=0;
    }

    public String longestCommonPrefix1(String[] strs) {
        return null;
    }


    /**
     * 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
     * 注意：本题相对原题稍作改动，只需返回未识别的字符数
     *
     * 示例：
     *
     * 输入：
     * dictionary = ["looked","just","like","her","brother"]
     *
     * sentence = "jesslookedjustliketimherbrother"
     * 输出： 7
     * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
     *
     * 链接：https://leetcode-cn.com/problems/re-space-lcci
     */


    public int respace(String[] dictionary, String sentence) {
         int count=0;
         Set<String> set=new HashSet<>();
         for (String s : dictionary) {
             set.add(s);
         }
         for (int i=0 ; i < sentence.length(); i++) {
             for (int j = i; j < sentence.length(); j++) {
                 String substring = sentence.substring(i, j  + 1);
                 if(set.contains(substring)){
                     i=j;
                     count++;
                     break;
                 }
             }
         }
         return count;
    }

    public int respace1(String[] dictionary, String sentence) {
        int count=0;
        Set<String> set=new HashSet<>();
        for (String s : dictionary) {
            set.add(s);
        }
        return count;
    }


    /**
     * 给你一个字符串 sentence 作为句子并指定检索词为 searchWord ，其中句子由若干用 单个空格 分隔的单词组成。
     *
     * 请你检查检索词 searchWord 是否为句子 sentence 中任意单词的前缀。
     *
     * 如果 searchWord 是某一个单词的前缀，则返回句子 sentence 中该单词所对应的下标（下标从 1 开始）。
     * 如果 searchWord 是多个单词的前缀，则返回匹配的第一个单词的下标（最小下标）。
     * 如果 searchWord 不是任何单词的前缀，则返回 -1 。
     * 字符串 S 的 「前缀」是 S 的任何前导连续子字符串。
     *
     *  
     *
     * 示例 1：
     * 输入：sentence = "i love eating burger", searchWord = "burg"
     * 输出：4
     * 解释："burg" 是 "burger" 的前缀，而 "burger" 是句子中第 4 个单词。
     *
     *
     * 输入：sentence = "i am tired", searchWord = "you"
     * 输出：-1
     * 解释："you" 不是句子中任何单词的前缀。
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] split = sentence.split(" ");
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            int length=s.length();
            boolean flag=true;
            for (int j = 0; j < searchWord.length(); j++) {
                if(j>=length){
                    flag=false;
                    break;
                }
                if(s.charAt(j) != searchWord.charAt(j)){
                    flag=false;
                    break;
                }
            }
            if(flag){
                return i+1;
            }
        }
        return -1;
    }


    /**
     * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
     * 示例 1：
     * 输入: s1 = "abc", s2 = "bca"
     * 输出: true
     * 示例 2：
     * 输入: s1 = "abc", s2 = "bad"
     * 输出: false
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/check-permutation-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        boolean res=true;
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            boolean flag=false;
            for (int j = 0; j < s2.length(); j++) {
                if(c == s2.charAt(j)){
                    s2=s2.replace(c+"","");
                    System.err.println("s2:"+s2);
                    flag=true;
                    break;
                }
            }
            System.err.println("flag:"+flag);
        }
        return res;
    }


    /**
     * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
     *
     * 示例1:
     *
     *  输入："aabcccccaaa"
     *  输出："a2b1c5a3"
     * 示例2:
     *
     *  输入："abbccd"
     *  输出："abbccd"
     *  解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
     * 提示：
     *
     * 字符串长度在[0, 50000]范围内。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/compress-string-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public String compressString(String S) {
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int count=1;
            System.err.println("c:"+c);
            System.err.println("index:"+i);
            while( i < S.length()-1 && c == S.charAt(i+1)  ){
                count++;
                i++;
            }
            sb.append(c+""+count);
        }
        String s = sb.toString();
        return s.length() >= S.length() ? S:s;
    }


    /**
     * 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
     *
     * 请你返回字符串的能量。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：s = "leetcode"
     * 输出：2
     * 解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
     * 示例 2：
     *
     * 输入：s = "abbcccddddeeeeedcba"
     * 输出：5
     * 解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/consecutive-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int maxPower(String s) {
        int max=0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count=1;
            while( i < s.length()-1 && c == s.charAt(i+1)  ){
                count++;
                i++;
            }
            max=Math.max(count,max);
        }
        return max;
    }

    /**
     * 以字符串的形式读入两个数字，再以字符串的形式输出两个数字的和。
     *
     * 输入描述:
     * 输入两行，表示两个数字a和b，-109 <= a , b <= 109  ，用双引号括起。
     *
     * 输出描述:
     * 输出a+b的值，用双引号括起。
     *
     * 输入例子1:
     * "-26"
     * "100"
     *
     * 输出例子1:
     * "74"
     * 6 5 4 3 2 1
     *
     */

    public String addStr(String a,String b){
        Integer anum = Integer.valueOf(a);
        Integer bnum = Integer.valueOf(b);
        return anum+bnum+"";
    }


    public static void main(String[] args) {
        char ch1=97;
        char ch2='a';
        System.out.println(" ch1="+ch1);
        System.out.println(" ch2="+ch2);
    }
}
