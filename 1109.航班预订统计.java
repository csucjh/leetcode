/*
 * @lc app=leetcode.cn id=1109 lang=java
 *
 * [1109] 航班预订统计
 */

// @lc code=start
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // 初始化一份航班预定数据
        int[] nums = new int[n];

        // 构造一份差分数组
        Diff diff = new Diff(nums);

        // 开始处理航班数据
        for(int[] booking : bookings){
            diff.incr(booking[0], booking[1], booking[2]);
        }

        // 根据差分数组还原返回结果
        return diff.result();

    }

    static class Diff{
        
        int[] diff;

        // 构建差分数组
        public Diff(int[] nums){
            diff = new int[nums.length];
            diff[0] = nums[0];
            for(int i = 1; i < nums.length; i++){
                diff[i] = nums[i] - nums[i-1];
            }
            //System.out.println(Arrays.toString(diff));
        }

        // 从left -> right 每个元素加val
        // left\right都是从1开始的数值
        public void incr(int left, int right, int val){
            diff[left-1] += val;
            if(right < diff.length){
                diff[right] -= val;
            }
        }

         // 返回由差分数组diff还原后的数组
        public int[] result(){
            int[] nums = new int[diff.length];
            nums[0] = diff[0];
            for(int i = 1; i < nums.length; i++){
                nums[i] = nums[i-1] + diff[i];
            }

            //System.out.println(Arrays.toString(nums));
            return nums;
        }
    }
}
// @lc code=end

