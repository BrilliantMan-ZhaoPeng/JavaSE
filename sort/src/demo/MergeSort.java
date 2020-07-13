package demo;
/**
 * 归并排序的实现
 * @author zhaopeng
 * @create 2020-05-26 9:58
 */
public class MergeSort {
    public static void main(String[] args) {
       int arr[]={1,3,2,1,7,6,5,10,12};
        //先排序左边
        sort1(arr,0,arr.length-1);
        //sort1(arr,5,6,5);
        print(arr);
    }

    public static void sort(int[] arr,int left,int right){
        if(left==right){
            return ;
        }
        int mid=left+(right-left)/2;
        //左边
        sort(arr,left,mid);
        //右边
        sort(arr,mid+1,right);

        merge(arr,left,mid,right);
    }

    //5 2 6 8 3 9
    public static void merge(int[] arr,int left,int mid,int right){
        int[] temp=new int[right-left+1];
        int i = left;//左边开始
        int j = mid+1;//右边开始
        int k = 0;//temp下标
        while(i<=mid&&j<=right){
            temp[k++]=arr[i]<=arr[j]?arr[i++]:arr[j++];
           /* if(arr[i] <= arr[j]){
                temp[k++]=arr[i];
                i++;
            }else if(arr[i]>arr[j]){
                temp[k++]=arr[j];
                j++;
            }*/
        }

        //1 5 7 0 2 8 9
        while(i<=mid){
           temp[k++]=arr[i++];
        }

        while(j<=right){
            temp[k++]=arr[j++];
        }


        for (int l = 0; l < temp.length; l++) {
            arr[left++]=temp[l];
        }

        //print(temp);
    }

    //排序实现
    public static void sort1(int[] arr,int left,int right){
        if(left==right){
            return;
        }
        //存放结果的数组
        int result[]=new int[right-left+1];
        int i=left;
        int mid=(right+left)/2;
        int j=mid+1;
        int m=left;
        //中间值
        int index=0;

        //递归执行左边
        sort1(arr,left,mid);

        //递归执行右边
        sort1(arr,mid+1,right);

        while(i<=mid&&j<=right){
            if(arr[i]<=arr[j]){
                 result[index++]=arr[i++];
            }
            if(arr[i]>arr[j]){
                 result[index++]=arr[j++];
            }
        }
        //将左边没有执行完的放到result中
        while(i<=mid){
            result[index++]=arr[i];
            i++;
        }

        while(j<=right){
            result[index++]=arr[j];
            j++;
        }

        for (int k = 0; k < result.length; k++) {
            arr[m++]=result[k];
        }
       // print(result);
    }

    public static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.err.print(arr[i]+" ");
        }
        System.err.println("\n");
    }
}
