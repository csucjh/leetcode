/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 *
 * https://leetcode.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (43.21%)
 * Total Accepted:    500.8K
 * Total Submissions: 1.2M
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * Example:
 * 
 * 
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * 
 * 
 * Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 * 
 * 最大子序和
 */
class Solution {
    
    public int maxSubArray(int[] nums) {
        int sum = 0, res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(sum > 0){
                sum += nums[i];
            }else{
                sum = nums[i];
            }
            res = Math.max(sum, res);
        }
        return res;
    }

    // 找到和最大子序列索引
    public int maxSubArray2(int[] nums) {
        int start = 0;
        int end = 0;
        int max = 0;

        int temp = 0;
        int ts = 0;
        for(int i = 0; i < nums.length; i++) {
            temp += nums[i];
            if(temp < 0) {
                ts = i + 1;
                temp = 0;
            } else {
                if(temp > max) {
                    start = ts;
                    end = i;
                    max = temp;
                }
            }
        }

        System.out.println("maxSum = " + max + ", start : " + start + ", end = " + end);
        return max;
    }
}

