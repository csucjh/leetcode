/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 问题实际转化为找倒数第n+1个节点(要删除倒数第n个必须找到上一个)
        // 为了边界条件好处理，用一个虚拟头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;


        ListNode p1 = dummy, p2 = dummy;
        int k = n + 1;
        
        // p1先前进k，然后同步前进p2,当p1到末尾时p2在倒数第k个节点
        while(p1.next != null){
            if(k > 1){
                k--;
            }else{
                p2 = p2.next;
            }

            p1 = p1.next;
        }

        // 此时p2已在倒数k处
        p2.next = p2.next.next;

        return dummy.next;
    }
}
// @lc code=end

