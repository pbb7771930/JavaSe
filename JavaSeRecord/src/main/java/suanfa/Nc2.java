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
public class Nc2 {
    /*
    方法一：
    ArrayList的底层就是用数组实现的，所以将链表储存在一个ArrayList中，然后利用双指针，一个指向最前面，一个指向最后面，
    依次访问并向题目要求的链表形式进行转换！
     */
    public void reorderList1(ListNode head) {
        if (head == null) {
            return;
        }
        //  ArrayList为线性表
        List<ListNode> list = new ArrayList<>();
        // 将 链表的每一个节点依次 存进ArrayList中
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        // 两个指正依次从前 后进行遍历取元素
        int i = 0, j = list.size() - 1;
        while (i < j) {
            //  eg:  1->2->3->4
            // 前面的节点的下一个节点指向最后的节点,即 1->4
            list.get(i).next = list.get(j);
            // 此时 i++ 则此时 list.get(i) 为原来前面节点的下一个节点   即节点2
            i++;
            // 若 链表长度为偶数的情况下 则会提前相遇，此时已达到题目要求，直接终止循环
            if (i == j)
            {
                break;
            }
            // 4->2
            list.get(j).next = list.get(i);
            // 此时刚刚的例子则变为  1->4->2->3
            j--;
        }
        // 最后一个节点的下一个节点为null
        list.get(i).next = null;
    }

    /*
    方法二：
    可以利用 快慢指针，快指针一次走两步，慢指针依次走一步，当快指针走到终点的时候，此时如果链表的长度为偶数时，
    此时中间节点有两个，慢指针则走到了左端点。反之，慢指针则走到中间节点。
     */
    public void reorderList2(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        //1、快慢指针找出中间点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //fast.next == null  长度为奇数,否则长度为偶数
        //定义中间节点
        ListNode mid = slow.next;
        slow.next = null;
        //以mid为起点，反转后面的节点
        ListNode newHead = reverse(mid);

        //3、合并链表，把head和newHead合并,节点交叉互换
        while (newHead != null) {
            //保存下一个节点
            ListNode temp = newHead.next;
            //指向head的下一节点
            newHead.next = head.next;
            //head的下一节点指向newHead
            head.next = newHead;
            // head后移
            head = newHead.next;
            newHead = temp;
        }

    }
    //2、反转链表方法
    public ListNode reverse(ListNode head){
        if(head == null) {
            return head;
        }
        //2.1、先把头节点变成尾节点
        //head 值给tail，tail为head下一节点
        ListNode tail = head;
        //head 指向下一个节点
        head = head.next;
        //tail变为尾节点
        tail.next = null;

        //2.2、反转后面的节点
        while(head != null){
            // temp储存了此时头结点的下一个结点
            ListNode tmp = head.next;
            // 头结点的下一个结点指向 tail
            head.next = tail;
            // 此时的头结点则变为尾结点
            tail = head;
            // 刚刚储存起来的结点则为头结点
            head = tmp;
        }
        return tail;
    }

    public static void main(String[] args) {
        ListNode ls1 = new ListNode(1);
        ListNode ls2 = new ListNode(2);
        ListNode ls3 = new ListNode(3);
        ListNode ls4 = new ListNode(4);
        ls1.next = ls2;
        ls2.next = ls3;
        ls3.next = ls4;
        ls4.next = null;
        Nc2 testNc2 = new Nc2();
        //testNc2.reorderList1(ls1);
        testNc2.reorderList2(ls1);
        //测试输出
        while(ls1 != null){
            System.out.println(ls1.val);
            ls1 = ls1.next;
        }
    }

}
