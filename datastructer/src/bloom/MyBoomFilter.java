package bloom;
/**
 * 布隆过滤器最最最简单的实现
 *
 * 1.一个合适大小的位数组保存数据
 * 2.几个不同的哈希函数
 * 3.添加元素到位数组（布隆过滤器）的方法实现
 * 4.判断给定元素是否存在于位数组（布隆过滤器）的方法实现。
 * @author zhaopeng
 * @create 2020-06-17 14:49
 */
public class MyBoomFilter {
    //数组默认长度的大小
    private int DEFAULT_SIZE=2<<12;

    //位数组
    private int[] datas;

    //用于创建几个不同的哈希函数
    private int[] SEEDS={1,23,4,124,41};

    public MyBoomFilter(){
        datas=new int[DEFAULT_SIZE];
    }

    //根据seed计算hash函数
    private int hash(Object o,int seed){
        return o.hashCode()%seed;
    }

    //增加值
    public void add(Object o){
        for (int i = 0; i < SEEDS.length; i++) {
           int tempHash=hash(o,SEEDS[i]);
           datas[tempHash]++;
        }
    }


    public boolean find(Object o){
        for (int i = 0; i < SEEDS.length ; i++) {
             int tempHash=hash(o,SEEDS[i]);
             if(datas[tempHash]==0){
                 return false;
             }
        }
        return true;
    }


    public static void main(String[] args) {
        MyBoomFilter filter=new MyBoomFilter();
        filter.add("1");
        filter.add(new Integer(2));
        boolean b = filter.find(new Integer(2));
        System.err.println(b);
        Integer i=new Integer(12312);
        Integer j=new Integer(12312);
        System.err.println(i.equals(j));
        System.err.println(i.hashCode());
        System.err.println(j.hashCode());
    }
}

