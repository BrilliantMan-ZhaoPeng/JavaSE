package demo.array;
import com.sun.deploy.panel.ITreeNode;
import com.sun.xml.internal.ws.assembler.jaxws.MustUnderstandTubeFactory;
import org.omg.PortableInterceptor.INACTIVE;

import javax.swing.*;
import java.lang.annotation.Target;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.stream.IntStream;

/**
 * @author zhaopeng
 * @create 2020-06-29 10:28
 */
public class Solution {
    /**
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * 示例 1:
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     * 示例 2:
     *
     * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     * 输出: 4
     *
     * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
     * @param nums
     * @param k
     * @return
     */
        public int findKthLargest(int[] nums, int k) {
            Arrays.sort(nums);
            return nums[nums.length-k];
        }


        public int findKthLargest2(int[] nums, int k) {
            final PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int val : nums) {
                queue.add(val);
                if (queue.size() > k)
                    queue.poll();
                }
            return queue.peek();
        }


    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *
     *  
     *
     * 示例:
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */

    public int[] twoSum(int[] nums, int target) {
        int[] res=new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            int temp=target-nums[i];
            if(map.containsKey(temp)){
                res[0]=i;
                res[1]=map.get(temp);
            }
            map.put(nums[i],i);
        }
        return res;
    }


    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     *
     * 输入：(2 -> 4) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 5
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6)
     * 输出：7 -> 0 -> 4
     *
     * 原因：342 + 465 = 807
     */
     public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
          }
     }

     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode head=new ListNode(0);
         ListNode res=head;
         int curr=0;//进位 1 0
         while(l1!=null||l2!=null){
             int x = l1==null?0:l1.val;
             int y = l2==null?0:l2.val;
             //求的和
             int sum=x+y+curr;
             curr=sum/10;
             res.next=new ListNode(sum%10);
             res=res.next;
             if(l1!=null){
                 l1=l1.next;
             }
             if(l2!=null){
                 l2=l2.next;
             }
         }
         if(curr>0){
             res.next=new ListNode(curr);
         }
         return head.next;
     }


     public static void printListNode(ListNode head){
           while(head!=null){
               System.err.print(head.val+" ");
               head=head.next;
           }

     }


    /**
     * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
     * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * 你可以假设 nums1 和 nums2 不会同时为空。
     * 示例 1:
     * nums1 = [1, 3]
     * nums2 = [2]
     * 则中位数是 2.0
     * 示例 2:
     *
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     *
     * 则中位数是 (2 + 3)/2 = 2.5
     */


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
          //将两个数组合并在一起
           int[] res=new int[nums1.length+nums2.length];
           int index=0;
           int index1=0;
           int index2=0;
           while(index1<nums1.length&&index2<nums2.length){
               if(nums1[index1]<nums2[index2]) {
                   res[index++] = nums1[index1++];
               }else if(nums1[index1]>=nums2[index2]){
                   res[index++]=nums2[index2++];
               }
            }
            while(index1<nums1.length){
                res[index++]=nums1[index1++];
            }
            while(index2<nums2.length){
                res[index++]=nums2[index2++];
            }
             //寻找中位数
            if(res.length%2==0){//偶数情况
                return (res[res.length/2]+res[res.length/2-1])/2.0;
            }else{//奇数情况
               return res[res.length/2];
            }
    }

    /**
     * 给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，其中 paths[i] = [cityAi, cityBi] 表示该线路将会从 cityAi 直接前往 cityBi 。请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市。
     *
     * 题目数据保证线路图会形成一条不存在循环的线路，因此只会有一个旅行终点站。
     *
     * 示例 1：
     *
     * 输入：paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
     * 输出："Sao Paulo"
     * 解释：从 "London" 出发，最后抵达终点站 "Sao Paulo" 。本次旅行的路线是 "London" -> "New York" -> "Lima" -> "Sao Paulo" 。
     * 示例 2：
     *
     * 输入：paths = [["B","C"],["D","B"],["C","A"]]
     * 输出："A"
     * 解释：所有可能的线路是：
     * "D" -> "B" -> "C" -> "A". 
     * "B" -> "C" -> "A". 
     * "C" -> "A". 
     * "A". 
     * 显然，旅行终点站是 "A" 。
     * 示例 3：
     *
     * 输入：paths = [["A","Z"]]
     * 输出："Z"
     */

    public String destCity(List<List<String>> paths) {
        String res="";
        //直接返回第一组的目的地
        if(paths.size()==1){
            return paths.get(0).get(1);
        }
        //将所有的数据放到set中
        Set<String>  startSet=new HashSet<>();
        Set<String>  endSet=new HashSet<>();
        
        //将每个节点的数据放到set中
        for (List<String> path : paths) {
            String start = path.get(0);
            String end = path.get(1);
            startSet.add(start);
            endSet.add(end);
        }

        endSet.removeAll(startSet);


        Iterator<String> iterator = endSet.iterator();
        while(iterator.hasNext()){
             res=iterator.next();
        }
        return res;
    }


    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
     *
     * 说明：
     *
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     *
     * 示例 1:
     *
     * 输入: [2,2,3,2]
     * 输出: 3
     * 示例 2:
     *
     * 输入: [0,1,0,1,0,1,99]
     * 输出: 99
     *
     */

    public int singleNumber(int[] nums) {
        int res=0;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num=nums[i];
            if(map.containsKey(num)){
                 map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }
        Set<Integer> integers = map.keySet();
        Iterator<Integer> iterator = integers.iterator();
        while(iterator.hasNext()){
            int key=iterator.next();
            if(map.get(key)==1){
                res=key;
                break;
            }
        }
        return res;
    }


    /**
     * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
     *
     * 示例 1:
     *
     * 输入:
     * A: [1,2,3,2,1]
     * B: [3,2,1,4,7]
     * 输出: 3
     * 解释:
     * 长度最长的公共子数组是 [3, 2, 1]。
     * 说明:
     *
     * 1 <= len(A), len(B) <= 1000
     * 0 <= A[i], B[i] < 100
     *
     */

    public int findLength(int[] A, int[] B) {
        int max=0;
        for (int i = 0; i < A.length; i++) {
            int x = A[i];
            for (int j = 0; j < B.length; j++) {
                if(x==B[j]){
                    int count = 0;
                    int a=i;
                    int b=j;
                    while(a<A.length&&b<B.length&&A[a]==B[b]){
                        count++;
                        a++;
                        b++;
                    }
                    max=Math.max(max,count);
                }
            }
        }
        return max;
    }


    public int findLength1(int[] A, int[] B) {
        int max=0;
        int[][] res=new int[A.length+1][B.length+1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if(A[i-1]==B[j-1]){
                    res[i][j]=res[i-1][j-1]+1;
                }else{
                    res[i][j]=0;
                }
                max=Math.max(res[i][j],max);
            }
        }
        return max;
    }


    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     *
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
     *
     * 注意：你不能在买入股票前卖出股票。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     * 示例 2:
     *
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     */

    public int maxProfit(int[] prices) {
        int max=0;
        for (int i = 0; i < prices.length; i++) {
            int temp=prices[i];
            for (int j = i+1; j < prices.length; j++) {
                max=Math.max(max,prices[j]-temp);
            }
        }
        return max;
    }

    public int maxProfit1(int[] prices) {
        //最小的买入的价格
        int minBuy=prices[0];
        //最大的利润
        int maxProfit=0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit=Math.max(maxProfit,prices[i]-minBuy);

            minBuy=Math.min(minBuy,prices[i]);
        }
        return maxProfit;
    }


    /**
     * 给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
     *
     * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
     *
     * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
     *
     *
     *
     * 示例 1：
     *
     * 输入：
     * nums = [1, 7, 3, 6, 5, 6]
     * 输出：3
     * 解释：
     * 索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
     * 同时, 3 也是第一个符合要求的中心索引。
     * 示例 2：
     *
     * 输入：
     * nums = [1, 2, 3]
     * 输出：-1
     * 解释：
     * 数组中不存在满足此条件的中心索引。
     */
    public int pivotIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int leftCount=0;
            for (int j = i+1; j <nums.length ; j++) {
               leftCount+=nums[j];
            }

            int rightCount=0;

            for (int k = 0; k < i ; k++) {
                rightCount+=nums[k];
            }

            if(leftCount==rightCount){
                return i;
            }
        }
        return -1;
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 你可以假设数组中无重复元素。
     * 示例 1:
     *
     * 输入: [1,3,5,6], 5
     * 输出: 2
     * 示例 2:
     *
     * 输入: [1,3,5,6], 2
     * 输出: 1
     * 示例 3:
     *
     * 输入: [1,3,5,6], 7
     * 输出: 4
     * 示例 4:
     *
     * 输入: [1,3,5,6], 0
     * 输出: 0
     */
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>=target){
                return i;
            }
            if(i==nums.length-1){
                return i+1;
            }
        }
        return -1;
    }


    /**
     * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
     *
     * 不占用额外内存空间能否做到？
     *
     *  
     *
     * 示例 1:
     *
     * 给定 matrix =
     * [
     *   [1,2,3],
     *   [4,5,6],
     *   [7,8,9]
     * ],
     *
     * 原地旋转输入矩阵，使其变为:
     * [
     *   [7,4,1],
     *   [8,5,2],
     *   [9,6,3]
     * ]
     * 示例 2:
     *
     * 给定 matrix =
     * [
     *   [ 5, 1, 9,11],
     *   [ 2, 4, 8,10],
     *   [13, 3, 6, 7],
     *   [15,14,12,16]
     * ],
     *
     * 原地旋转输入矩阵，使其变为:
     * [
     *   [15,13, 2, 5],
     *   [14, 3, 4, 1],
     *   [12, 6, 8, 9],
     *   [16, 7,10,11]
     * ]
     *
     * 链接：https://leetcode-cn.com/problems/rotate-matrix-lcci
     */

    public void rotate(int[][] matrix) {
        //中间数组
        int[][] res=new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            int index=0;
            for (int j = 0; j < matrix.length; j++) {
                res[index++][matrix.length-i-1]=matrix[i][j];
            }
        }

        for (int i = 0; i <res.length ; i++) {
            for (int j = 0; j < res[i].length; j++) {
                matrix[i][j]=res[i][j];
            }
        }
    }


    /**
     * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
     * 示例 1：
     * 输入：
     * [
     *   [1,1,1],
     *   [1,0,1],
     *   [1,1,1]
     * ]
     * 输出：
     * [
     *   [1,0,1],
     *   [0,0,0],
     *   [1,0,1]
     * ]
     * 示例 2：
     *
     * 输入：
     * [
     *   [0,1,2,0],
     *   [3,4,5,2],
     *   [1,3,1,5]
     * ]
     * 输出：
     * [
     *   [0,0,0,0],
     *   [0,4,5,0],
     *   [0,3,1,0]
     * ]
     * @param matrix
     */

    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] tmp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                tmp[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (tmp[i][j] == 0) {
                    for (int m = 0; m < row; m++) {
                        matrix[m][j] = 0;
                    }
                    for (int n = 0; n < col; n++) {
                        matrix[i][n] = 0;
                    }
                }
            }
        }
    }


    public void printRotate(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.err.print(matrix[i][j]+" ");
            }
            System.err.println();
        }
    }


    /**
     * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
     *
     * 返回的长度需要从小到大排列。
     *
     * 示例：
     *
     * 输入：
     * shorter = 1
     * longer = 2
     * k = 3
     * 输出： {3,4,5,6}
     * 提示：
     *
     * 0 < shorter <= longer
     * 0 <= k <= 100000
     *
     * 链接：https://leetcode-cn.com/problems/diving-board-lcci
     */

    int index=0;

    public int[] divingBoard(int shorter, int longer, int k) {
        if(k==0){
            return null;
        }
        int[] temp=new int[2*k];
        int size=0;
        for (int i = 0; i < k; i++) {
            int rest=k-i;
            temp[size++]=shorter*i+rest*longer;
            temp[size++]=rest*shorter+i*longer;
        }
        long count = Arrays.stream(temp).distinct().count();
        int[] res=new int[(int)count];
        IntStream sorted = Arrays.stream(temp).distinct().sorted();
        sorted.forEach((data)->{
            res[index++]=data;
        });
        return res;
    }

    public int[] divingBoard1(int shorter, int longer, int k) {
        if(k==0){
            return new int[]{};
        }else if(shorter==longer){
            return new int[]{shorter * k};
        }
        int res[]=new int[k+1];
        for (int i = 0; i <= k; i++) {
            res[i]=shorter*(k-i)+longer*i;
        }
        return res;
    }


    /**
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     * 示例 1:
     * 输入: nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
     * 解释: 9 出现在 nums 中并且下标为 4
     * 示例 2:
     *
     * 输入: nums = [-1,0,3,5,9,12], target = 2
     * 输出: -1
     * 解释: 2 不存在 nums 中因此返回 -1
     *  
     *
     * 提示：
     *
     * 你可以假设 nums 中的所有元素是不重复的。
     * n 将在 [1, 10000]之间。
     * nums 的每个元素都将在 [-9999, 9999]之间。
     *
     * 链接：https://leetcode-cn.com/problems/binary-search
     */
    public int search(int[] nums, int target) {
        return searchProcess(nums,target,0,nums.length-1);
    }

    public int searchProcess(int[] nums,int target,int L,int R){
        if(L>R){
            return -1;
        }
         int mid=L + ((R-L) >> 1);
       // int mid=(L+R)/2;
        if(target==nums[mid]){
           return mid;
        }else if(target<nums[mid]){//往左边走
           return searchProcess(nums,target,L,mid-1);
        }else{//右边走
            return searchProcess(nums,target,mid+1,R);
        }
    }


    /**
     * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
     *
     * 示例:
     *
     * 输入: [5,2,6,1]
     * 输出: [2,1,1,0]
     * 解释:
     * 5 的右侧有 2 个更小的元素 (2 和 1).
     * 2 的右侧仅有 1 个更小的元素 (1).
     * 6 的右侧有 1 个更小的元素 (1).
     * 1 的右侧有 0 个更小的元素.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    //暴力解法，，不通过所有的测试用例
    public List<Integer> countSmaller(int[] nums) {
         List<Integer> res=new ArrayList<>();
         for (int i = 0; i < nums.length; i++) {
             int count=0;
             int num=nums[i];
             for (int j = i+1; j < nums.length; j++) {
                 if(num>nums[j]){
                     count++;
                 }
             }
             res.add(count);
         }
         return res;
    }

    int count=0;
    public List<Integer> countSmaller1(int[] nums) {
        List<Integer> res=new ArrayList<>();
        for (int i = 0; i < nums.length-1; i++) {
            int[] temp=new int[nums.length-i-1];
            int index=0;
            for (int j = i+1; j < nums.length; j++) {
                temp[index++]=nums[j];
            }
            System.err.println(temp.length);
            Arrays.sort(temp);
            countSmallerProcess(temp,i+1,nums.length-1,nums[i]);
            res.add(count);
            count=0;
        }
        return res;
    }


    public void countSmallerProcess(int[] arr,int L,int R,int target){
        if(L>=R){
            return ;
        }
        int mid = L + ((R-L)>>1);
        System.err.println("mid:"+mid);
        if(arr[mid] <= target){//走右边去
            count++;
            countSmallerProcess(arr,mid+1,R,target);
        }else{//走左边去
            count++;
            countSmallerProcess(arr,L,mid-1,target);
        }
    }

    /**
     *二分查找
     */
    public boolean doubleSearch(int[] arr,int target){
        Arrays.stream(arr);
        return searchProcesss(arr,0,arr.length-1,target);
    }

    public boolean searchProcesss(int[] arr,int L,int R,int target){
        if(L>=R){
           return arr[L]==target;
        }
        int mid = L + ((R-L)>>1);
        System.err.println("mid:"+mid);
        if(arr[mid] == target){
            return true;
        }else if(arr[mid] < target){//走右边去
            count++;
            return searchProcesss(arr,mid+1,R,target);
        }else{//走左边去
            count++;
            return searchProcesss(arr,L,mid-1,target);
        }
    }

    /**
     * 快速排序的实现
     * @param arr
     */
    public void quickSort(int[] arr){
        merge(arr,0,arr.length-1);
    }

    public void merge(int[] nums,int L,int R){
        //表示到达中点了
        if(L>=R){
            return ;
        }
        int left=L;
        int right=R;
        int base=nums[left++];
        while(left!=right){
            while(left<right&&nums[right]>base){
                right--;
            }
            while(left<right&&nums[left]<=base){
                left++;
            }
            swap(nums,left,right);
        }
        nums[L]=nums[left];
        nums[left]=base;
        //左边
        merge(nums,left,L-1);
        merge(nums,L+1,right);
    }

    //交换值
    public void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }


    /**
     * 给你一个目标数组 target 和一个整数 n。每次迭代，需要从  list = {1,2,3..., n} 中依序读取一个数字。
     *
     * 请使用下述操作来构建目标数组 target ：
     *
     * Push：从 list 中读取一个新元素， 并将其推入数组中。
     * Pop：删除数组中的最后一个元素。
     * 如果目标数组构建完成，就停止读取更多元素。
     * 题目数据保证目标数组严格递增，并且只包含 1 到 n 之间的数字。
     *
     * 请返回构建目标数组所用的操作序列。
     *
     * 题目数据保证答案是唯一的。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：target = [1,3], n = 3
     * 输出：["Push","Push","Pop","Push"]
     * 解释：
     * 读取 1 并自动推入数组 -> [1]
     * 读取 2 并自动推入数组，然后删除它 -> [1]
     * 读取 3 并自动推入数组 -> [1,3]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/build-an-array-with-stack-operations
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public List<String> buildArray(int[] target, int n) {
        List<String> res=new ArrayList<>();
        for (int i = 1; i < target[0]; i++) {
            res.add("Push");
            res.add("Pop");
        }

        for (int i = 0; i < target.length-1; i++) {
            res.add("Push");
            int nowData=target[i];
            int nextData=target[i+1];
            for (int j = 0; j < nextData-nowData-1 ; j++) {
                res.add("Push");
                res.add("Pop");
            }
        }
        res.add("Push");
        return res;
    }


    /**
     * 给你一个数字数组 arr 。
     *
     * 如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
     *
     * 如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：arr = [3,5,1]
     * 输出：true
     * 解释：对数组重新排序得到 [1,3,5] 或者 [5,3,1] ，任意相邻两项的差分别为 2 或 -2 ，可以形成等差数列。
     * 示例 2：
     *
     * 输入：arr = [1,2,4]
     * 输出：false
     * 解释：无法通过重新排序得到等差数列。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/can-make-arithmetic-progression-from-sequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean canMakeArithmeticProgression(int[] arr) {
        //an = a1+(n-1)*d
        if(arr.length<=2){
            return true;
        }

        Arrays.sort(arr);
        int a1=arr[0];
        int cha=arr[1]-arr[0];
        for (int i = 2; i < arr.length; i++) {
            if(arr[i]!=(a1+i*cha)){
                return false;
            }
        }
        return true;
    }


    /**
     * 给你一个 n 行 m 列的矩阵，最开始的时候，每个单元格中的值都是 0。
     *
     * 另有一个索引数组 indices，indices[i] = [ri, ci] 中的 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
     *
     * 你需要将每对 [ri, ci] 指定的行和列上的所有单元格的值加 1。
     *
     * 请你在执行完所有 indices 指定的增量操作后，返回矩阵中 「奇数值单元格」 的数目。
     *
     *  
     *
     * 示例 1：
     *
     *
     *
     * 输入：n = 2, m = 3, indices = [[0,1],[1,1]]
     * 输出：6
     * 解释：最开始的矩阵是 [[0,0,0],[0,0,0]]。
     * 第一次增量操作后得到 [[1,2,1],[0,1,0]]。
     * 最后的矩阵是 [[1,3,1],[1,3,1]]，里面有 6 个奇数。
     * 示例 2：
     *
     *
     *
     * 输入：n = 2, m = 2, indices = [[1,1],[0,0]]
     * 输出：0
     * 解释：最后的矩阵是 [[2,2],[2,2]]，里面没有奇数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/cells-with-odd-values-in-a-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int oddCells(int n, int m, int[][] indices) {
        int count=0;
        int[][] temp=new int[n][m];
        for (int i = 0; i < indices.length; i++) {
            int[] index = indices[i];
            int row=index[0];//行
            int col=index[1];//列
            for (int j = 0; j < m; j++) {
                temp[row][j]=temp[row][j]+1;
            }
            for (int j = 0; j < n; j++) {
                temp[j][col]=temp[j][col]+1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(temp[i][j] % 2 != 0){
                    count++;
                }
            }
        }

        return count;
    }


    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     *
     * 示例 1:
     *
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2,2]
     * 示例 2:
     *
     * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出: [4,9]
     * 说明：
     *
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
     * 我们可以不考虑输出结果的顺序。
     * 进阶:
     *
     * 如果给定的数组已经排好序呢？你将如何优化你的算法？
     * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
     * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    //法1：HashMap的方式
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            int num=nums1[i];
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }

        List<Integer> list=new ArrayList();

        for (int i = 0; i < nums2.length; i++) {
            int num=nums2[i];
            if(map.containsKey(num) && map.get(num) != 0){
                list.add(num);
                map.put(num,map.get(num)-1);
            }
        }

        int[] res=new int[list.size()];
        for (int i = 0; i <res.length ; i++) {
            res[i]=list.get(i);
        }
        return res;
    }

    //法2：sort的方式
    // 1 2 2     1 1 2 3

    public int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1=nums1.length;
        int length2= nums2.length;
        int index1=0;
        int index2=0;
        int[] res=new int[Math.min(length1,length2)];
        int index=0;
        while(index1<length1 && index2<length2){
            if(nums1[index1] == nums2[index2]){
                res[index++]=nums1[index1];
                index1++;
                index2++;
            }else if(nums1[index1] < nums2[index2]){
                index1++;
            }else{
                index2++;
            }
        }
        return Arrays.copyOfRange(res,0,index);
    }


    public void printArr(int[] arr){
        for (int i = 0; i <arr.length ; i++) {
            System.err.print( arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums1={4,9,5};//5,2,6,1   2 1 1 0
        int[] nums2={9,4,9,8,4};  // 4 5 9    4 4 8 9 9
        int[] intersect = solution.intersect1(nums1, nums2);
        solution.printArr(intersect);
    }
}
