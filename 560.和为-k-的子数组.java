/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为 K 的子数组
 */

// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> preMap = new HashMap<>(); 
        preMap.put(0, 1);

        int preSum = 0, count = 0;
        for(int i = 0; i < nums.length; i++){
            preSum += nums[i];

            // 求差值
            int sub = preSum - k;

            // 这里一定是在当前前缀和放到map之前计数
            count += preMap.getOrDefault(sub, 0);

            preMap.put(preSum, preMap.getOrDefault(preSum, 0) + 1);
        }

        return count;
    }
}
// @lc code=end

