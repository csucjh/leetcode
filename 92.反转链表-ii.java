/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == 1){
            // 3、退出条件——当left为1，不再是当前递归函数的含义
            // 演变成了反转链表的前TopN节点
            return reverseTopN(head, right);
        }

        // 1、明确递归函数含义
        ListNode newHead = reverseBetween(head.next, left - 1, right - 1);

        // 2、将head指向反转后的newHead
        head.next = newHead;

        return head;
    }

    public ListNode reverseTopN(ListNode head, int n){
        if(n == 1){
            // 6、明确退出条件——当n为1，不需要反转了，head直接返回
            return head;
        }

        // 4、新递归公式含义——反转前n个节点并返回新的头结点
        ListNode newHead = reverseTopN(head.next, n - 1);

        // 5、把当前head挂到反转链上，然后将head指向第n+1个节点(这样反转链才完整)
        ListNode successor = head.next.next;
        head.next.next = head;
        head.next = successor;

        return newHead;
    }
}
// @lc code=end

