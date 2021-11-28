/*
 * @lc app=leetcode.cn id=1094 lang=java
 *
 * [1094] 拼车
 */

// @lc code=start
class Solution {
    
    // 问题就是一个差分数组，最后只要判断恢复的数组每一位是否小于capacity
    public boolean carPooling(int[][] trips, int capacity) {

        // 获取最长行程
        int n = 0;
        for(int[] trip : trips){
            n = n >= trip[2] ? n : trip[2];
        }
    
        // 因为行程是从0开始算，所以这里数组为n+1
        Diff diff = new Diff(n + 1);

        for(int[] trip : trips){
            diff.incr(trip[1], trip[2], trip[0]);
        }
        
        // 结果每一位代表行程为i时，承载的乘客数
        int[] result = diff.result();
        for(int i = 0; i < result.length; i++){
            if(result[i] > capacity){
                return false;
            }
        }

        return true;
    }

    static class Diff{
        
        int[] diff;

        // 构建差分数组
        public Diff(int n){
            diff = new int[n];
        }

        // 从left -> right 每个元素加val
        // left\right在这里从0开始
        public void incr(int left, int right, int val){
            diff[left] += val;
            // 每段行程末尾减去乘客，含义是先下车
            diff[right] -= val;
            //System.out.println(Arrays.toString(diff));
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

