package suanfa;

import java.util.ArrayList;
import java.util.List;


/*
NC2 重排链表
将给定的单链表\ L L： L_0→L_1→…→L_{n-1}→L_ nL0​→L1​→…→Ln−1​→Ln​
重新排序为：L_0→L_n →L_1→L_{n-1}→L_2→L_{n-2}→…L0​→Ln​→L1​→Ln−1​→L2​→Ln−2​→…
要求使用原地算法，不能只改变节点内部的值，需要对实际的节点进行交换。

数据范围：链表长度 200000≤n≤20000 ，链表中每个节点的值满足10000≤val≤1000
要求：空间复杂度 O(n)O(n) 并在链表上进行操作而不新建链表，时间复杂度 O(n)O(n)
进阶：空间复杂度 O(1)O(1) ， 时间复杂度 O(n)O(n)

示例1
输入：
{1,2,3,4}
返回值：
{1,4,2,3}
说明：
给定head链表1->2->3->4, 重新排列为 1->4->2->3,会取head链表里面的值打印输出 1
 */
public class nc2 {
    /*
    方法一：
    ArrayList的底层就是用数组实现的，所以将链表储存在一个ArrayList中，然后利用双指针，一个指向最前面，一个指向最后面，
    依次访问并向题目要求的链表形式进行转换！
     */
    public void reorderList1(main.java.suanfa.ListNode head) {
        if (head == null)
            return;
        List<main.java.suanfa.ListNode> list = new ArrayList<>();   //  ArrayList为线性表
        // 将 链表的每一个节点依次 存进ArrayList中
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        // 两个指正依次从前 后进行遍历取元素
        int i = 0, j = list.size() - 1;
        while (i < j) {
            //  eg:  1->2->3->4
            // 前面的节点的下一个节点指向最后的节点
            list.get(i).next = list.get(j);  //  即 1->4
            i++;  // 此时 i++ 则此时 list.get(i) 为原来前面节点的下一个节点   即节点2
            if (i == j) // 若 链表长度为偶数的情况下 则会提前相遇，此时已达到题目要求，直接终止循环
                break;
            list.get(j).next = list.get(i);   // 4->2
            // 此时刚刚的例子则变为  1->4->2->3
            j--;
        }
        list.get(i).next = null;  // 最后一个节点的下一个节点为null
    }

    /*
    方法二：
    可以利用 快慢指针，快指针一次走两步，慢指针依次走一步，当快指针走到终点的时候，此时如果链表的长度为偶数时，
    此时中间节点有两个，慢指针则走到了左端点。反之，慢指针则走到中间节点。
     */
    public void reorderList2(main.java.suanfa.ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;

        main.java.suanfa.ListNode slow = head;
        main.java.suanfa.ListNode fast = head.next;
        //1、快慢指针找出中间点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //fast.next == null  长度为奇数,否则长度为偶数
        main.java.suanfa.ListNode mid = slow.next; //定义中间节点
        slow.next = null;
        main.java.suanfa.ListNode newHead = reverse(mid); //以mid为起点，反转后面的节点

        //3、合并链表，把head和newHead合并,节点交叉互换
        while (newHead != null) {
            main.java.suanfa.ListNode temp = newHead.next;  //保存下一个节点
            newHead.next = head.next;  //指向head的下一节点
            head.next = newHead; //head的下一节点指向newHead
            head = newHead.next; // head后移
            newHead = temp;
        }

    }
    //2、反转链表方法
    public main.java.suanfa.ListNode reverse(main.java.suanfa.ListNode head){
        if(head == null)
            return head;
        //2.1、先把头节点变成尾节点
        main.java.suanfa.ListNode tail = head;  //head 值给tail，tail为head下一节点
        head = head.next; //head 指向下一个节点
        tail.next = null; //tail变为尾节点
        //2.2、反转后面的节点
        while(head != null){
            main.java.suanfa.ListNode tmp = head.next; // temp储存了此时头结点的下一个结点
            head.next = tail; // 头结点的下一个结点指向 tail
            tail = head; // 此时的头结点则变为尾结点
            head = tmp; // 刚刚储存起来的结点则为头结点
        }
        return tail;
    }

    public static void main(String[] args) {
        main.java.suanfa.ListNode ls1 = new main.java.suanfa.ListNode(1);
        main.java.suanfa.ListNode ls2 = new main.java.suanfa.ListNode(2);
        main.java.suanfa.ListNode ls3 = new main.java.suanfa.ListNode(3);
        main.java.suanfa.ListNode ls4 = new main.java.suanfa.ListNode(4);
        ls1.next = ls2;
        ls2.next = ls3;
        ls3.next = ls4;
        ls4.next = null;
        nc2 testNc2 = new nc2();
        //testNc2.reorderList1(ls1);
        testNc2.reorderList2(ls1);
        //测试输出
        while(ls1 != null){
            System.out.println(ls1.val);
            ls1 = ls1.next;
        }
    }

}
