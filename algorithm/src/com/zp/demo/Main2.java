package com.zp.demo;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author zhaopeng
 * @create 2020-06-22 10:42
 */
public class Main2 {
    public static void main(String[] args) {
        int[] A = {1,3,5,7,8};
        int[] B = {2,4,6,9};
        int[] datas = merge(A, B);
        for (int i = 0; i < datas.length; i++) {
            System.err.print(datas[i] + " ");
        }
    }

    public static void sort(int[] datas, int L, int R) {
        if (R == L) {
            return;
        }
        int MID = L + (R - L) / 2;
        sort(datas, L, MID);
        sort(datas, MID + 1, R);
        merge(datas, L, MID, R);
    }

    public static void merge(int[] datas, int L, int MID, int R) {
        int temp[] = new int[R - L + 1];
        int leftIndex = L;
        int rightIndex = MID + 1;
        int index = 0;
        while (leftIndex <= MID && rightIndex <= R) {
            temp[index++] = datas[leftIndex] > datas[rightIndex] ? datas[rightIndex++] : datas[leftIndex++];
        }
        while (leftIndex <= MID) {
            temp[index++] = datas[leftIndex++];
        }
        while (rightIndex <= R) {
            temp[index++] = datas[rightIndex++];
        }
        //temp数组copy到datas中
        System.arraycopy(temp, 0, datas, L, temp.length);
    }

    public static void swap(int[] datas, int i, int j) {
        datas[i] ^= datas[j];
        datas[j] ^= datas[i];
        datas[i] ^= datas[j];
    }

    //将两个排好序的数组，组合成一个有序的数组返回去
    public static int[] merge(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < arr1.length && j < arr2.length) {
            res[index++] = arr1[i] > arr2[j] ? arr2[j++] : arr1[i++];
        }
        while (i < arr1.length) {
            res[index++] = arr1[i++];
        }
        while (j < arr2.length) {
            res[index++] = arr2[j++];
        }
        return res;
    }

    //整合到nums1中
    public void merge(int[] A, int m, int[] B, int n) {//m是A数组的长度F，n是B数组的长度
        int i=m-1;
        int j=n-1;
        int index=m+n-1;
        while(i>=0&&j>=0){
           A[index--]=A[i]>A[j]?A[i--]:A[j--];
        }
        while(j>=0){
          A[index--]=B[j--];
        }
    }
    //A 1,3,5,7,8,[],[],[],[]
    //B 2,4,6,9
}
