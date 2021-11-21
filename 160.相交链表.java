/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        boolean b1 = true, b2 = true;

        // 思想是，A + B 等于 B + A
        // p1按照A B顺序前进，p2按照B A顺序前进，第一个相等的节点就是交点
        while(p1 != p2){
            if(p1 == null){
                p1 = headB;
            }else{
                p1 = p1.next;
            }

           
            if(p2 == null){
                p2 = headA;
            }else{
                p2 = p2.next;
            }
        }


        return p1;
    }
}
// @lc code=end

