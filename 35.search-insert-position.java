/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 *
 * https://leetcode.com/problems/search-insert-position/description/
 *
 * algorithms
 * Easy (40.63%)
 * Total Accepted:    383.1K
 * Total Submissions: 942.3K
 * Testcase Example:  '[1,3,5,6]\n5'
 *
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,3,5,6], 5
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [1,3,5,6], 2
 * Output: 1
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: [1,3,5,6], 7
 * Output: 4
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: [1,3,5,6], 0
 * Output: 0
 * 
 * 
 */
class Solution {
    public int searchInsert1(int[] nums, int target) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            index = i;
            if(target <= nums[i]){
                break;
            }

            if(target > nums[i]){
                continue;
            }
        }
        return target > nums[nums.length-1] ? index + 1: index;
    }

    /**
     * 上一种简化后的
     */
    public int searchInsert2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if(target <= nums[i]){
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 二分查找
     */
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0)
            return -1;
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int mid = (left+right)/2;
            if(target == nums[mid])
                return mid;
            if(target<nums[mid]){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return left;
    }
}

