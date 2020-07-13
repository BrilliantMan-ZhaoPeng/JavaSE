package demo.strategy;
import java.util.Comparator;
/**
 * 策略模式的直接体现，，，，实现一个接口
 * @author zhaopeng
 * @create 2020-07-13 18:32
 */

public class CatAgeComparator<T> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        Cat cat1=(Cat)o1;
        Cat cat2=(Cat)o2;
        return cat1.getAge()-cat2.getAge();
    }
}
