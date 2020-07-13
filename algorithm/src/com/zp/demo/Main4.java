package com.zp.demo;
/**
 * @author zhaopeng
 * @create 2020-06-22 12:25
 */
public class Main4 {
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    static void print(ListNode head){
          while(head!=null){
              System.err.print(head.val+"-->");
              head=head.next;
          }
          System.err.print("null");
    }

    //找到环状开始的头
    public static ListNode getNode(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null||fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
               ListNode temp=head;
               while(temp!=slow){
                 temp=temp.next;
                 slow=slow.next;
               }
               return temp;
            }
        }
        return null;
    }
    //判断是否成环状
    public static boolean checkCycle(ListNode head){
        //判断是两个节点的情况
        if(head.next==head){
            return true;
        }
        //快指针
        ListNode fast=head.next.next;
        //慢指针
        ListNode low=head;

        //考虑到奇偶数问题
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            low=low.next;
            if(fast==low){
               return true;
            }
        }
        return false;
    }

    //反转链表
    public static ListNode reverse(ListNode head){
        ListNode res=null;
        ListNode next=null;
        while(head!=null){
            next=head.next;

            head.next=res;
            res=head;

            head=next;
        }
        return res;
    }


    //反转链表
    public static ListNode reverse2(ListNode head){
        if(head.next==null){
            return head;
        }
        ListNode next=head.next;

        ListNode newNode=reverse2(head.next);

        next.next=head;

        head.next=null;

        return newNode;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        ListNode reverse = reverse2(head);
        print(reverse);
    }

}
