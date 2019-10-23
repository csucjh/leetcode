/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            if(temp < 0){

            }else{

            }
        }

        return sum;
    }
}

