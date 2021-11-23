/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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

    int count = 0;

    private void print(int count){
        for(int i = 0; i < count; i++){
            System.out.print("————");
        }
    }

    public ListNode reverseList(ListNode head) {
        print(count++);
        System.out.println("head val:" + head.val);
        if(head.next == null){
            print(--count);
            System.out.println("return:" + head.val);
            return head;
        }

        ListNode last = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        print(--count);
        System.out.println("return:" + last.val);
        return last;
    }
}
// @lc code=end

