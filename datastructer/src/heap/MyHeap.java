package heap;
/**
 * 堆
 * @author zhaopeng
 * @create 2020-06-14 20:09
 */
public class MyHeap {
    public int[] datas;

    public int size;

    public MyHeap(){
        datas=new int[20];
    }
    public void insert(int num){
            datas[size++]=num;
            swap(size-1);
    }

    public void swap(int index){
        while(index>0){
            int father=(index-1)/2;
            if(datas[index]<=datas[father]){
                break;
            }
            int temp=datas[index];
            datas[index]=datas[father];
            datas[father]=temp;
            index=father;
        }
    }

    public int getMax(){
        if(size==0){
            return -1;
        }
        int res=datas[0];
        return res;
    }


    public int popMax(){
        if(size==0){
            return -1;
        }
        int res=datas[0];
        datas[0]=datas[size-1];
        datas[size-1]=0;
        size--;
        //从上往下，将最大的数弄到第一个节点上，datas[0]=max;
        int father=0;
        while((2*father+1)<size){
            int left=2*father+1;
            int rigth=left+1;
            int index=left;
            if(datas[left]<datas[rigth]){
                index=rigth;
            }
            swap(index,father);
            father=index;
        }
        return res;
    }


    public void swap(int index1,int index2){
        int temp=datas[index1];
        datas[index1]=datas[index2];
        datas[index2]=temp;
    }

    public void print(){
        for (int i = 0; i < size; i++) {
            System.err.print(datas[i]+" ");
        }
    }


    public static void main(String[] args) {
        MyHeap heap=new MyHeap();
        heap.insert(2);
        heap.insert(4);
        heap.insert(3);
        heap.insert(9);
        heap.insert(1);
        heap.insert(120);
        System.err.println(heap.popMax());
      //  System.err.println(heap.popMax());
        //System.err.println(heap.popMax());
        heap.print();
    }
}
