package demo;
/**
 * 二分查找的实现
 * @author zhaopeng
 * @create 2020-05-31 12:41
 */
public class BinarySearch {
    public static void main(String[] args) {
        int datas[]={1,2,3,4,4,4,8};
        boolean b = find(1, datas);
        System.err.println(b);
    }

    public static boolean find(int pos,int datas[]){
        int left=0;
        int right=datas.length-1;
        while(left<right){
            int mid=left+((right-left)>>1);
            if(datas[mid]==pos){
                return true;
            }else if(datas[mid]>pos){//找左边
               right=mid-1;
            }else{//找右边
                left=mid+1;
            }
        }
         return datas[left]==pos;
    }
}
