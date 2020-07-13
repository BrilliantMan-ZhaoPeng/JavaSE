package demo.linked;

import com.sun.org.apache.bcel.internal.generic.FADD;
import demo.Test;
import demo.extra.T;

import java.util.*;

/**
 * @author zhaopeng
 * @create 2020-07-02 11:26
 */

public class Solution {
    /**
     * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     *
     * 示例:
     *
     * 输入:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 输出: 1->1->2->3->4->4->5->6
     *
     */
    //法一、直接先排序完，然后再返回
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head=new ListNode(0);
        ListNode currNode=head;
        List<Integer> res=new ArrayList();
        for (int i = 0; i < lists.length ; i++) {
            ListNode list = lists[i];
            while(list!=null){
                res.add(list.val);
                list=list.next;
            }
        }
        res.sort((a,b)->{
            return a-b;
        });
        for (Integer ss : res) {
            currNode.next=new ListNode(ss);
            currNode=currNode.next;
        }
        return head.next;
    }


    /**
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
     *
     *  
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 k = 2.
     *
     * 返回链表 4->5.
     *
     * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
     */

    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head==null){
            return null;
        }
        int count=0;
        ListNode curr=head;
        ListNode res=head;
        while(curr!=null){
             count++;
             curr=curr.next;
        }
        int index=0;
        while(index<count-k){
            index++;
            res=res.next;
        }
        return res;
    }

    public ListNode getKthFromEnd1(ListNode head, int k) {
        if(head==null){
           return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(k>0){
            k--;
            fast=fast.next;
        }

        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        System.err.println(slow.val);
        return slow;
    }


    /**
     * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     *
     *  
     *
     * 进阶：
     *
     * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
     *
     *  
     *
     * 示例：
     *
     * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 8 -> 0 -> 7
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return null;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        s.getKthFromEnd1(l1,2);
    }
}
