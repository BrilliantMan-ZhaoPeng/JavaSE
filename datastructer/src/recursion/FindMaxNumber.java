package recursion;

import javax.print.attribute.standard.Fidelity;
import java.util.logging.Level;

/**
 * 查询给定一个数据中的最大数，利用递归实现
 * @author zhaopeng
 * @create 2020-06-02 14:04
 */
public class FindMaxNumber {
    public static void main(String[] args) {
     int arr[]={2,543,6,3,3,5,6,7,1};
        int i = find(arr, 0, arr.length - 1);
        System.err.println(i);
    }
    public static int find(int[] arr,int left,int right){
        if(left==right){
            return arr[left];
        }
        int mid=left+((right-left)>>1);
        int leftMax=find(arr,left,mid);
        System.err.println("leftMax:"+leftMax);
        int rightMax=find(arr,mid+1,right);
        System.err.println("rightMax:"+rightMax);
        return Math.max(leftMax,rightMax);
    }
}
