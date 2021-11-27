/*
 * @lc app=leetcode.cn id=303 lang=java
 *
 * [303] 区域和检索 - 数组不可变
 */

// @lc code=start
class NumArray {

    int[] preNums;

    public NumArray(int[] nums) {
        // 前缀和数组长度为n+1，是为了方便处理nums中第0位的前缀和
        preNums = new int[nums.length + 1];

        // base case(这句只是为了提现base case，实际没有意义)
        preNums[0] = 0;  
        
        for(int i = 1; i < preNums.length; i++){
            // 动态规划dp数组含义 dp[i] = dp[i - 1] + nums[i - 1]
            preNums[i] = preNums[i - 1] + nums[i - 1];
        }
    }
    
    public int sumRange(int left, int right) {
        return preNums[right + 1] - preNums[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
// @lc code=end

