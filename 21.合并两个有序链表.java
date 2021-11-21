/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 虚拟头结点
        ListNode head = new ListNode(-1);

        // 游标
        ListNode p = head;
        
        //  比较l1和l2,只有有多个才需要对比
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }

            p = p.next;
        }

        // 如果某个链表还有剩余的，就一定是最大的部分
        if(l1 != null){
            p.next = l1;
        }

        if(l2 != null){
            p.next = l2;
        }

        return head.next;
    }
}
// @lc code=end

