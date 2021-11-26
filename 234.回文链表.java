/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
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
    
    /**
     * 1、快慢指针找到中点
     * 2、反转中点以后的部分
     * 3、左右指针向中间靠拢对比
     */
    public boolean isPalindrome(ListNode head) {
        
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode last = reverse(slow);

        while(last != null){
            if(last.val != head.val){
                return false;
            }

            last = last.next;
            head = head.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        if(head.next == null){
            return head;
        }

        ListNode newHead = reverse(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
// @lc code=end

