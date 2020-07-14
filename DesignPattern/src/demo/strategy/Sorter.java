package demo.strategy;
/**
 * @author zhaopeng
 * @create 2020-07-13 17:02
 */
public class Sorter<T> {
    //整个插入排序的算法
    public  void sort(T[] arr, Comparator<T> comparator){//comparator就是不同的策略
        if(arr.length == 1){
            return;
        }
        T num=null;
        int index=0;
        for (int i = 1; i < arr.length; i++) {
            num=arr[i];
            index=i;
            //表名需要插入
            while(index > 0 && comparator.compare(arr[index-1],num) > 0) {
                arr[index]=arr[index-1];
                index--;
            }
            arr[index]=num;
        }
    }


    public static void main(String[] args) {
        Cat a=new Cat("c1",12,12);
        Cat b=new Cat("c2",3,123);
        Cat c=new Cat("c1",4,12);
        Cat[] cats={a,b,c};
        Sorter<Cat> sorter=new Sorter<>();
       // sorter.sort(cats,new CatAgeComparator());//按照年龄比较
        sorter.sort(cats,new CatWeightComparator());
        for (Cat cat : cats) {
            System.err.print(cat+" ");
        }
    }
}
