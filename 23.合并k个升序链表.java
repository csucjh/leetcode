/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }

        int k = lists.length;

        ListNode head = new ListNode(-1);
        ListNode p = head;

        // 难点在于每次找到k个元素中的最小值，这里用最小堆实现
        // 第一个参数是初始容量，第二个参数是比较器，升序就是构造最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(k, (a, b) -> a.val - b.val);

        // 初始化：每个子序列都放当前第一个元素进去
        for(ListNode n : lists){
            if(n != null){
                pq.offer(n);
            }
        }

        // 只要堆里还有数据说明还没取完
        while(!pq.isEmpty()){
            // 找到k个元素中最小的
            ListNode min = pq.poll();
            p.next = min;
            p = min;

            // 如果当前序列还有下一个则放入下一个
            if(min.next != null){
                pq.offer(min.next);
            }
        }

        return head.next;
    }
}
// @lc code=end

