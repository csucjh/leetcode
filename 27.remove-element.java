/*
 * @lc app=leetcode id=27 lang=java
 *
 * [27] Remove Element
 *
 * https://leetcode.com/problems/remove-element/description/
 *
 * algorithms
 * Easy (44.07%)
 * Total Accepted:    391.8K
 * Total Submissions: 888.6K
 * Testcase Example:  '[3,2,2,3]\n3'
 *
 * Given an array nums and a value val, remove all instances of that value
 * in-place and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * The order of elements can be changed. It doesn't matter what you leave
 * beyond the new length.
 * 
 * Example 1:
 * 
 * 
 * Given nums = [3,2,2,3], val = 3,
 * 
 * Your function should return length = 2, with the first two elements of nums
 * being 2.
 * 
 * It doesn't matter what you leave beyond the returned length.
 * 
 * 
 * Example 2:
 * 
 * 
 * Given nums = [0,1,2,2,3,0,4,2], val = 2,
 * 
 * Your function should return length = 5, with the first five elements of nums
 * containing 0, 1, 3, 0, and 4.
 * 
 * Note that the order of those five elements can be arbitrary.
 * 
 * It doesn't matter what values are set beyond the returned length.
 * 
 * Clarification:
 * 
 * Confused why the returned value is an integer but your answer is an array?
 * 
 * Note that the input array is passed in by reference, which means
 * modification to the input array will be known to the caller as well.
 * 
 * Internally you can think of this:
 * 
 * 
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeElement(nums, val);
 * 
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len
 * elements.
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * 
 */
class Solution {
    /**
     * 把要删除的替换到数组后端
     * Time:O(n^2)
     * Space:O(1)
     */
    public int removeElement1(int[] nums, int val) {
        int len = 0, temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                len++;
                continue;                
            }

            for (int j = nums.length - 1; j >= i; j--) {   
                if(nums[j] != val){
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    len++;
                    break;
                }
            }
        }
        return len;
    }

    /**
     * 使用双指针
     * Time:O(n)
     * Space:O(1)
     */
    public int removeElement(int[] nums, int val) {
        int i = 0, j = nums.length;
        for( ;i < j; ){
            if(nums[i] == val){
                nums[i] = nums[j - 1];
                j--;
            }else{
                i++;
            }
        }
        return i;
    }
}

