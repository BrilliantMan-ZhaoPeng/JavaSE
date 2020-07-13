package demo.BinaryTree;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;
import demo.recursion.Main;
import javafx.scene.layout.StackPane;
import sun.reflect.generics.tree.Tree;

import javax.xml.crypto.Data;
import java.nio.file.FileStore;
import java.time.temporal.ValueRange;
import java.util.*;
import java.util.logging.Level;
import java.util.stream.StreamSupport;
import java.util.zip.ZipEntry;

/**
 * @author zhaopeng
 * @create 2020-07-03 10:08
 */
public class Solution {
    /**
     * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
     *
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     *
     * 示例:
     *
     * 给定有序数组: [-10,-3,0,5,9],
     *
     * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
     *
     *       0
     *      / \
     *    -3   9
     *    /   /
     *  -10  5
     */

    public TreeNode sortedArrayToBST(int[] nums) {
        return help(nums,0,nums.length-1);
    }

    public TreeNode help(int[] nums,int left,int right){
        if(left>right){
            return null;
        }
        int mid=(left+right)/2;
        TreeNode node=new TreeNode(nums[mid]);
        node.left=help(nums,left,mid-1);
        node.right=help(nums,mid+1,right);
        return node;
    }


    /**
     * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 输出：[3, 14.5, 11]
     * 解释：
     * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3.0, 14.5, 11.0] 。
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Integer> counts=new ArrayList<>();
        List<Double> res=new ArrayList<>();
        averageOfLevelsHelp(0,counts,res,root);
        for (int i = 0; i < counts.size() ; i++) {
             res.set(i,res.get(i)/counts.get(i));
        }
        return res;
    }


    public void averageOfLevelsHelp(int height,List<Integer> counts,List<Double> res ,TreeNode head){
        if(head==null){
           return;
        }
        if(height<counts.size()){
            //层数的节点数量+1
            counts.set(height,counts.get(height)+1);
            res.set(height,res.get(height)+head.val);
        }else{
            counts.add(height,1);
            res.add(height,(double) head.val);
        }
        //左边
        averageOfLevelsHelp(height+1,counts,res,head.left);
                //右边
        averageOfLevelsHelp(height+1,counts,res,head.right);
    }

    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * 本题中，一棵高度平衡二叉树定义为：
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
     * 示例 1:
     * 给定二叉树 [3,9,20,null,null,15,7]
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回 true
     *
     * 示例 2:
     *
     * 给定二叉树 [1,2,2,3,3,null,null,4,4]
     *
     *        1
     *       / \
     *      2   2
     *     / \
     *    3   3
     *   / \
     *  4   4
     * 返回 false 。
     */

    public boolean isBalanced(TreeNode root) {
        BalancedInfo balancedProcess = isBalancedProcess(root);
        return balancedProcess.flag;
    }

     public class BalancedInfo{
        private int height;
        private boolean flag;
        public BalancedInfo(int height, boolean flag) {
            this.height = height;
            this.flag = flag;
        }
    }

    public BalancedInfo isBalancedProcess(TreeNode node){
        if(node==null){
            return new BalancedInfo(0,true);
        }
        //左边
        BalancedInfo leftInfo  = isBalancedProcess(node.left);
        //右边
        BalancedInfo rightInfo = isBalancedProcess(node.right);
        int height=Math.max(leftInfo.height,rightInfo.height)+1;
        boolean flag=false;
        if(Math.abs(leftInfo.height-rightInfo.height)<=1&&leftInfo.flag&&rightInfo.flag){
            flag=true;
        }
        return new BalancedInfo(height,flag);
    }


    /**
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例: 
     * 给定如下二叉树，以及目标和 sum = 22，
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \      \
     *         7    2      1
     * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
     *
     * 链接：https://leetcode-cn.com/problems/path-sum
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        if(root.left==null&&root.right==null){
            return sum==root.val;
        }
        boolean b = hasPathSum(root.left, sum - root.val);
        boolean b1 = hasPathSum(root.right, sum - root.val);
        return b|b1;
    }


    /**
     * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例:
     * 给定如下二叉树，以及目标和 sum = 22，
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \    / \
     *         7    2  5   1
     * 返回:
     *
     * [
     *    [5,4,11,2],
     *    [5,8,4,5]
     * ]
     *
     * 链接：https://leetcode-cn.com/problems/path-sum-ii
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        return null;
    }


    /**
     * 给定一个二叉树，返回它的中序 遍历。
     *
     * 示例:
     *
     * 输入: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * 输出: [1,3,2]
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack();
        TreeNode curr=root;

        while(curr!=null) {
            stack.push(curr);
            curr = curr.left;
        }

        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();
            res.add(pop.val);
            if(pop.right!=null){
                curr= pop.right;
                while(curr!=null) {
                    stack.push(curr);
                    curr = curr.left;
                }
            }
        }
        return res;
    }




    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack();
        TreeNode curr=root;
        while(curr!=null || !stack.isEmpty()) {
            while(curr!=null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr=stack.pop();
            res.add(curr.val);
            curr=curr.right;
        }
        return res;
    }

    public void inorderTraversalProcess(TreeNode node,List<Integer> list){
        if(node==null){
             return ;
        }
        inorderTraversalProcess(node.left,list);
        list.add(node.val);
        inorderTraversalProcess(node.right,list);
    }


    /**
     *
     给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。



     示例：
     二叉树：[3,9,20,null,null,15,7],

     3
     / \
     9  20
     /  \
     15   7
     返回其层次遍历结果：

     [
     [3],
     [9,20],
     [15,7]
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return null;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> res=new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List list=new ArrayList();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if(poll.left!=null){
                   queue.add(poll.left);
                }
                if(poll.right!=null){
                    queue.add(poll.right);
                }
            }
            res.add(list);
        }
        return res;
    }


    /**
     * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     *
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其自底向上的层次遍历为：
     *
     * [
     *   [15,7],
     *   [9,20],
     *   [3]
     * ]
     *
     * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
     */
    //法一，，，，从上往下遍历，利用stack 和 Queue
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list=new ArrayList();
        if(root==null){
            return list;
        }
        Stack<List<Integer>> stack=new Stack();
        Queue<TreeNode> queue=new LinkedList();
        TreeNode curr=root;
        queue.add(curr);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> res=new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                res.add(poll.val);
                if(poll.left != null){
                    queue.add(poll.left);
                }
                if(poll.right != null){
                    queue.add(poll.right);
                }
            }
            stack.push(res);
        }

        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }



    //法二，，，，从上往下遍历，只利用Queue
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> list=new ArrayList();
        if(root==null){
            return list;
        }
        Stack<List<Integer>> stack=new Stack();
        Queue<TreeNode> queue=new LinkedList();
        TreeNode curr=root;
        queue.add(curr);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> res=new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                res.add(poll.val);
                if(poll.left != null){
                    queue.add(poll.left);
                }
                if(poll.right != null){
                    queue.add(poll.right);
                }
            }
            list.add(0,res);
        }
        return list;
    }


    /**
     * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例:
     *
     * 输入:
     *
     *    1
     *  /   \
     * 2     3
     *  \
     *   5
     *
     * 输出: ["1->2->5", "1->3"]
     *
     * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-paths
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res=new ArrayList<>();
        binaryTreePathsProcess(root,res,"");
        return res;
    }

    //法一、递归的方式
    public void binaryTreePathsProcess(TreeNode node,List<String> res,String str){
        if(node.left == null && node.right == null){
            str+=node.val;
            res.add(str);
        }
        str+=node.val+"->";
        if(node.left!=null){
            binaryTreePathsProcess(node.left,res,str);
        }
        if(node.right!=null){
            binaryTreePathsProcess(node.right,res,str);
        }
    }

    //法二，stack的方式
    public List<String> binaryTreePaths1(TreeNode root) {
        TreeNode curr=root;
        List<String> res=new ArrayList<>();
        if(root == null){
            return res;
        }
        //存放节点
        Stack<TreeNode> stack=new Stack();
        //存放的是string类型
        Stack<String> stack1=new Stack();
        stack.add(root);
        stack1.add(root.val+"");
        while(!stack.isEmpty()){

            TreeNode pop = stack.pop();

            String str = stack1.pop();

            if(pop.left==null && pop.right==null){
                res.add(str);
            }

            if(pop.right!=null){
                stack.push(pop.right);
                stack1.push(str+"->"+pop.right.val);
            }

            if(pop.left!=null){
                stack.push(pop.left);
                stack1.push(str+"->"+pop.left.val);
            }
        }
        return res;
    }

    /**
     * 给定一个二叉树，返回它的 前序 遍历。
     *
     *  示例:
     *
     * 输入: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * 输出: [1,2,3]
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    //法一，递归的方式
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        preorderTraversalProcess(root,res);
        return res;
    }

    public void preorderTraversalProcess(TreeNode node,List<Integer> res){
        if(node==null){
            return;
        }
        res.add(node.val);
        preorderTraversalProcess(node.left,res);
        preorderTraversalProcess(node.right,res);
    }

    //法二，Stack的方式
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack=new Stack();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();
            //加入到list中
            res.add(pop.val);
            //为什么先放入右孩纸呢？因为先序遍历弹出的值先走左边
            //判断当前的节点是否存在右孩纸
            if(pop.right!=null){
               stack.push(pop.right);
            }
            //判断当前的节点是否存在左孩子
            if(pop.left!=null){
                stack.push(pop.left);
            }
        }
        return res;
    }


    /**
     * 给定一个二叉树，返回它的 后序 遍历。
     *
     * 示例:
     *
     * 输入: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * 输出: [3,2,1]
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    //法1：递归方式
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        postorderTraversalProcess(root,res);
        return res;
    }

    public void postorderTraversalProcess(TreeNode node,List<Integer> res){
        if(node != null){
            return ;
        }
        postorderTraversalProcess(node.left,res);
        postorderTraversalProcess(node.right,res);
        res.add(node.val);
    }

    //法二：Stack DFS
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.add(root);
        //上面的套路还是如此的
        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();
            //每次将得到的值加入到链表的最前面
            res.add(0,pop.val);
            if(pop.left!=null){
                stack.push(pop.left);
            }
            if(pop.right!=null){
                stack.push(pop.right);
            }
        }
        return res;
    }


    /**
     * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
     *
     *
     * 示例 1:
     * 给定二叉树 [3,9,20,null,null,15,7]
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回 true 。
     * 示例 2:
     * 给定二叉树 [1,2,2,3,3,null,null,4,4]
     *       1
     *      / \
     *     2   2
     *    / \
     *   3   3
     *  / \
     * 4   4
     * 返回 false 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/check-balance-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public boolean isBalanced1(TreeNode root) {
         return isBalanced1Process(root).flag;
    }

    class BalancedInfo1{
        private int height;
        private boolean flag;

        public BalancedInfo1(int height, boolean flag) {
            this.height = height;
            this.flag = flag;
        }
    }

    public BalancedInfo isBalanced1Process(TreeNode node){
        if(node==null){
            return new BalancedInfo(0,true);
        }
        BalancedInfo leftInfo = isBalanced1Process(node.left);
        BalancedInfo rightInfo = isBalanced1Process(node.right);
        boolean flag = leftInfo.flag&&rightInfo.flag;
        int height=Math.max(leftInfo.height,rightInfo.height)+1;
        if(Math.abs(leftInfo.height-rightInfo.height) > 1){
            flag=false;
        }
        return new BalancedInfo(height,flag);
    }


    /**
     * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     *
     * 示例:
     *
     * 输入: [1,2,3,null,5,null,4]
     * 输出: [1, 3, 4]
     * 解释:
     *
     *    1            <---
     *  /   \
     * 2     3         <---
     *  \     \
     *   5     4       <---
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue=new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            //得到当前节点还有多少节点
            int length = queue.size();
            res.add(((LinkedList<TreeNode>) queue).get(length-1).val);
            for (int i = 0; i < length; i++) {
                TreeNode poll = queue.poll();
                if(poll.left != null){
                    queue.add(poll.left);
                }
                if(poll.right != null){
                    queue.add(poll.right);
                }
            }
        }
        return res;
    }

    List<Integer> res=new ArrayList<>();
    public List<Integer> rightSideView1(TreeNode root) {
        rightSideView1Process(root,0);
        return res;
    }
    public void rightSideView1Process(TreeNode node,int height){
        if(node == null){
            return ;
        }
        if(height == res.size()){
            res.add(node.val);
        }
        height++;
        rightSideView1Process(node.right,height);
        rightSideView1Process(node.left,height);
    }


    /**
     * 给定一个二叉树，计算整个树的坡度。
     *
     * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
     *
     * 整个树的坡度就是其所有节点的坡度之和。
     *
     *  
     *
     * 示例：
     *
     * 输入：
     *          1
     *        /   \
     *       2     3
     *      /     /
     *     3     2
     * 输出：1
     * 解释：
     * 结点 2 的坡度: 0
     * 结点 3 的坡度: 0
     * 结点 1 的坡度: |2-3| = 1
     * 树的坡度 : 0 + 0 + 1 = 1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-tilt
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    class findTiltInfo{
        //当前节点的坡度
        private int dege;
        //当前节点的所有孩子的和
        private int sum;
        public findTiltInfo(int dege,int sum) {
            this.dege = dege;
            this.sum=sum;
        }
    }

    public int findTilt(TreeNode root) {
        findTiltInfo tiltProcess = findTiltProcess(root);
        return tiltProcess.dege;
    }

    public  findTiltInfo findTiltProcess(TreeNode node){
        if(node == null){
            return new findTiltInfo(0,0);
        }
        findTiltInfo leftInfo = findTiltProcess(node.left);
        findTiltInfo rightInfo = findTiltProcess(node.right);
        int dege=Math.abs(leftInfo.sum-rightInfo.sum)+leftInfo.dege+rightInfo.dege;
        int sum=leftInfo.sum+rightInfo.sum+node.val;
        return new findTiltInfo(dege,sum);
    }


    /**
     * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     *
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回锯齿形层次遍历如下：
     *
     * [
     *   [3],
     *   [20,9],
     *   [15,7]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> res=new ArrayList<>();
         if(root == null){
             return res;
         }
         boolean flag=true; //true表示从左到右   false表示从右到左边
         Queue<TreeNode> quque=new LinkedList<>();
         quque.add(root);
         while( !quque.isEmpty()){
             int size = quque.size();
             List<Integer> list=new ArrayList();
             if(flag){//表示从左到右
                 for (int i = 0; i < size; i++) {
                     TreeNode poll = quque.poll();
                     list.add(poll.val);
                     if(poll.left != null){
                        quque.add(poll.left);
                     }
                     if(poll.right != null){
                        quque.add(poll.right);
                     }
                 }
             }else{//表示从右到左
                 for (int i = 0; i < size; i++) {
                     TreeNode poll = quque.poll();
                     list.add(0,poll.val);
                     if(poll.left != null){
                         quque.add(poll.left);
                     }
                     if(poll.right != null){
                         quque.add(poll.right);
                     }
                 }
             }
             res.add(list);
             flag= !flag;
         }
         return res;
    }



    public static void main(String[] args) {
        Solution solution=new Solution();
        TreeNode head=new TreeNode(3);
        head.left=new TreeNode(9);
        head.right=new TreeNode(20);
        head.right.right=new TreeNode(7);
        head.right.left=new TreeNode(15);
        List<List<Integer>> lists = solution.zigzagLevelOrder(head);
        System.err.println(lists);
    }

}




























/**
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 *
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 *
 *  
 * 示例：
 *
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // 返回 3
 * iterator.next();    // 返回 7
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 9
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 15
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 20
 * iterator.hasNext(); // 返回 false
 *  
 * 提示：
 * next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
 * 链接：https://leetcode-cn.com/problems/binary-search-tree-iterator
 */
class BSTIterator1 {

    Stack<TreeNode> stack;

    public BSTIterator1(TreeNode root) {
        stack=new Stack<>();
        pushMinNode(root);
    }

    //将以当前节点为头结点最小的节点放入
    public void pushMinNode(TreeNode head){
        while(head!=null){
            stack.push(head);
            head=head.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode pop = stack.pop();
        if (pop.right != null) {
            this.pushMinNode(pop.right);
        }
        return pop.val;
    }
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}



class BSTIterator {
    TreeNode head;
    List<Integer> list;
    int size;
    int index=0;
    public BSTIterator(TreeNode root) {
         head=root;
         list=new ArrayList<>();
         //调用初始化的方法
         init(head,list);
         size=list.size();
    }
    public void init(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }
        init(root.left,list);
        list.add(root.val);
        init(root.right,list);
    }
    /** @return the next smallest number */
    public int next() {
        size--;
       return list.get(index++);
    }
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return size!=0;
    }
}

