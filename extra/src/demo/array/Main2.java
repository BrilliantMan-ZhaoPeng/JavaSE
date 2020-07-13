package demo.array;

import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhaopeng
 * @create 2020-06-26 10:16
 */

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N=0;
        N=scanner.nextInt();
        List<List> list=new ArrayList<List>(N);
        for (int i = 0; i < N; i++) {
            List<String> tempList=new ArrayList();
            tempList.add(scanner.nextLine());
            list.add(tempList);
        }

        for (int i = 0; i < N; i++) {
            List list1 = list.get(i);
            for (int j = 0; j < list1.size(); j++) {
                System.err.print(list1.get(j)+" ");
            }
        }
    }
}
