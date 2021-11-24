/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
    public ListNode reverseKGroup(ListNode head, int k) {
        // 4、退出条件，没有下一分段时返回null
        if(head == null){
            return null;
        }

        ListNode last = head;
        int n = k;
        while(--n > 0){
            // 4、退出条件，当前分段不足k个时返回当前分段头节点，不反转
            if(last.next == null){
                return head;
            }

            last = last.next;
        }
     
        // 4、退出条件，k==1则每个分段只有一个节点，不需要反转
        // 这一个退出条件不要也行，但是会空跑一遍递归栈，建议保留
        if(last == head){
            return head;
        }

        // 1、是一个递归性质问题，每一个子问题都是反转链表前k个节点，返回新头结点
        ListNode newHead = reverseKGroup(last.next, k);

        // 2、将当前分段的尾结点指向子问题返回的新头节点
        last.next = newHead;

        // 3、反转当前链表的头n个节点
        return reverseTopK(head, k);
    }

    public ListNode reverseTopK(ListNode head, int k){
        if(k == 1){
            // 3、明确退出条件——当k为1，不需要反转了，head直接返回
            return head;
        }

        // 1、新递归公式含义——反转前k个节点并返回新的头结点
        ListNode newHead = reverseTopK(head.next, k - 1);

        // 2、把当前head挂到反转链上，然后将head指向第n+1个节点(这样反转链才完整)
        ListNode successor = head.next.next;
        head.next.next = head;
        head.next = successor;

        return newHead;
    }
        
}
// @lc code=end

