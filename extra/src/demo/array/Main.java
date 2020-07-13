package demo.array;
/**
 * @author zhaopeng
 * @create 2020-06-18 17:23
 */
public class Main {
    static int[] datas={8,4,2,0,1,7,3,5};
    public static void main(String[] args) {
        int i=0;
        int j=1;
        int[] res=new int[datas.length];
        for (int k = 0; k <datas.length; k++) {
             if(datas[k]%2==0){
                 res[i]=datas[k];
                 i+=2;
             }else{
                 res[j]=datas[k];
                 j+=2;
             }
        }
        print(res);
    }

    public static void print(int[] datas){
        for (int i = 0; i <datas.length ; i++) {
            System.err.print(datas[i]+" ");
        }
    }

}
