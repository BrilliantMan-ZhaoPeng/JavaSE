package demo.topk;

import demo.A;

import java.util.Arrays;

/**
 * @author zhaopeng
 * @create 2020-07-02 10:26
 */

public class Solution {

    /**
     * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
     * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
     *
     * 示例：
     * matrix = [
     *    [ 1,  5,  9],
     *    [10, 11, 13],
     *    [12, 13, 15]
     * ],
     * k = 8,
     * 返回 13。
     */


    //法一：
    public int kthSmallest(int[][] matrix, int k) {
        int[] res=null;
        for (int i = 0; i < matrix.length; i++) {
           res=merge(res,matrix[i]);
        }
        //print(res);
        return res[k-1];
    }

    //合并两个有序数组
    public int[] merge(int[] A,int[] B){
        if(A==null){
             return B;
        }
        int[] res=new int[A.length+B.length];
        int index=0;
        int aIndex=0;
        int bIndex=0;
        while(aIndex<A.length&&bIndex<B.length){
             res[index++]= A[aIndex]<B[bIndex] ? A[aIndex++]:B[bIndex++];
        }
        while(aIndex<A.length){
            res[index++]=A[aIndex++];
        }
        while(bIndex<B.length){
            res[index++]=B[bIndex++];
        }
       // print(res);
        return res;
    }

    //法二:与法一思想一致
    public int kthSmallest1(int[][] matrix, int k) {
        int[] res=new int[matrix.length*matrix[0].length];
        int index=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
               res[index++]=matrix[i][j];
            }
        }
        Arrays.sort(res);
        return res[k-1];
    }

    public void print(int[] res){
        for (int i = 0; i < res.length; i++) {
            System.err.print(res[i]+" ");
        }
    }







    public static void main(String[] args) {
        Solution solution=new Solution();
       int[][] matrix = {{ 1,  5,  9},{10, 11, 13},{12, 13, 15}};
        int i = solution.kthSmallest1(matrix, 8);
        System.err.println(i);
    }
}
