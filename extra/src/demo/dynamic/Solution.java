package demo.dynamic;

import demo.A;

import java.time.Period;

/**
 * @author zhaopeng
 * @create 2020-07-06 20:08
 */

public class Solution {

    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     *
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     *
     * 问总共有多少条不同的路径？
     *
     * 示例 1:
     *
     * 输入: m = 3, n = 2
     * 输出: 3
     * 解释:
     *
     * 0 1
     * 1 2
     * 1 3
     *
     * 从左上角开始，总共有 3 条路径可以到达右下角。
     * 1. 向右 -> 向右 -> 向下
     * 2. 向右 -> 向下 -> 向右
     * 3. 向下 -> 向右 -> 向右
     * 示例 2:
     *
     * 输入: m = 7, n = 3
     * 输出: 28
     */


    public int uniquePaths(int m, int n) {
        if(m==1&&n==1){
             return 1;
        }
        int[][] res=new int[m][n];
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
              if(i==0&&j==0){
                  res[i][j]=0;
                  continue;
              }
              if((i==0&&j!=0) || (i!=0&&j==0)){
                  res[i][j]=1;
                  continue;
              }
              res[i][j]=res[i][j-1]+res[i-1][j];
            }
        }
  //      print(res);
        return res[m-1][n-1];
    }


    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     *
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     *
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     * 网格中的障碍物和空位置分别用 1 和 0 来表示。
     *
     * 说明：m 和 n 的值均不超过 100。
     *
     * 示例 1:
     *
     * 输入:
     * [
     *   [0,0,0],
     *   [0,1,0],
     *   [0,0,0]
     * ]
     *
     * 输出: 2
     * 解释:
     * 3x3 网格的正中间有一个障碍物。
     * 从左上角到右下角一共有 2 条不同的路径：
     * 1. 向右 -> 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右 -> 向右
     *
     * 0 0 0       1 1
     * 0 0 1
     * 0 0 0
     *
     * 链接：https://leetcode-cn.com/problems/unique-paths-ii
     */

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
          if(obstacleGrid[0][0]==1){
               return 0;
          }
          int m=obstacleGrid.length;
          int n=obstacleGrid[0].length;
          boolean row=false;//行
          boolean clo=false;//列
          int[][] res=new int[m][n];
          for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if(obstacleGrid[i][j]==1){
                    res[i][j]=0;
                    if(i==0){
                       row=true;
                    }
                    if(j==0){
                       clo=true;
                    }
                }else if(i==0||j==0){
                    if(i==0&&row){
                        res[i][j]=0;
                    }else if(j==0&&clo){
                        res[i][j]=0;
                    }else{
                        res[i][j]=1;
                    }
                }else{
                    res[i][j]=res[i][j-1]+res[i-1][j];
                }
            }
          }
          print(res);
          return res[m-1][n-1];
    }


    public void print(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.err.print(arr[i][j]+" ");
            }
            System.err.println();
        }
    }


    /**
     * 给定一个数组，数组里面包含币值大于0的币值，给定一个total总额，求这些币值能组合成total的方法数
     * 例如：
     * arr:[10,20] total 30
     * 输出：2
     * 因为：10*3=30,10+20=30
     */
    public int getWay(int[] arr,int total){
        return getWayProcess(arr,0,total);
    }

    //index 指的是选择到当前的币值     rest指的是经过选择后剩余的钱钱
    public int getWayProcess(int[] arr,int index,int rest){
        //就没得剩下的钱了  意味着选多了 叫你选100块钱，你结果整了150------>100-150=-50
        if(rest<0){
              return 0;
        }
        //已经进行到最后了
        if(index==arr.length){
           return rest==0 ? 1:0;
        }
        int ways=0;
        //增加当前币值的张数，再继续往后面玩
        for (int count = 0; arr[index]*count <= rest ; count++) {
            ways+=getWayProcess(arr,index+1,rest-arr[index]*count);
        }
        return ways;
    }

    public int getWayDp(int[] arr,int index,int rest,int[][] dp){
        //就没得剩下的钱了  意味着选多了 叫你选100块钱，你结果整了150------>100-150=-50
        if(dp[index][rest]!=-1){
            return dp[index][rest];
        }
        if(index==arr.length){
            dp[index][rest] =    rest==0 ? 1:0;
            return dp[index][rest];
        }
        int ways=0;
        //增加当前币值的张数，再继续往后面玩
        for (int count = 0; arr[index]*count <= rest ; count++) {
            ways+=getWayProcess(arr,index+1,rest-arr[index]*count);
        }
        dp[index][rest]=ways;
        return ways;
    }


    /**
     * 121. 买卖股票的最佳时机
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
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

    //暴力
    public int maxProfit(int[] prices) {
        int max=0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length ; j++) {
                max=Math.max(max,prices[j]-prices[i]);
            }
        }
        return max;
    }

    public int maxProfitDp(int[] prices) {
        int minBuy=prices[0];
        int maxPro=0;
        for (int i = 0; i < prices.length; i++) {
            maxPro=Math.max(maxPro,prices[i]-minBuy);
            minBuy=Math.min(prices[i],minBuy);
        }
        return maxPro;
    }


    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     *
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     * 示例 2:
     *
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     * 示例 3:
     *
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    int maxProfit=0;

    public int maxProfit2(int[] prices) {
      /*  if(prices.length<2){
            return 0;
        }
        dfs(prices,0,prices.length,0,0);
        return maxProfit;*/
        int res = 0;
        int len = prices.length;
        for (int i = 0; i < len - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            if (diff > 0) {
                res += diff;
            }
        }
        return res;
    }

//    https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/tan-xin-suan-fa-by-liweiwei1419-2/
    private void dfs(int[] prices, int index, int len, int status, int profit) {
            //当选择到最后了
            if(len==index){
                maxProfit=Math.max(profit,maxProfit);
                return ;
            }
            dfs(prices,index+1,len,status,profit);
            //表示不持有股票
            if(status==0){
                //直接买了
                dfs(prices,index+1,len,1,profit-prices[index]);
            }else{
              //表示持有股票
                //直接卖了
                dfs(prices,index+1,len,0,profit+prices[index]);
            }
    }


    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * 注意：给定 n 是一个正整数。
     *
     * 示例 1：
     *
     * 输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶
     * 2.  2 阶
     * 示例 2：
     *
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/climbing-stairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    //动态规划的方式
    public int climbStairs(int n) {
        if(n==1 || n==2){
            return n;
        }

        int[] dp=new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n ; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    //递归的方式 （记忆化）
    public int climbStairs2(int n){
        int[] dp=new int[n+1];
        return climbStairsProcess(n,dp);
    }

    public int climbStairsProcess(int n,int dp[]) {
        if(dp[n] > 0){
            return dp[n];
        }
        if(n == 1){
            dp[1] = 1;
        }else if (n == 2) {
            dp[2] = 2 ;
        }else{
            dp[n] = climbStairsProcess(n-1,dp)+climbStairsProcess(n-2,dp);
        }
        return dp[n];
    }



    public static void main(String[] args) {
        Solution solution=new Solution();
        int i = solution.climbStairs2(4);
        System.err.println(i);
    }
}
