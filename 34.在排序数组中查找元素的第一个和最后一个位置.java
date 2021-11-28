/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = -1, right = -1;
        if(nums.length > 0){
            left = leftBound(nums, target);

            right = rightBound(nums, target); 
        }

        return new int[]{left, right};
        
    }

    public int leftBound(int[] nums, int target){
        int left = 0, right = nums.length-1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            System.out.println(mid);
            if(nums[mid] == target){
                right = mid - 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }
        }

        if(left >= nums.length || nums[left] != target){
            return -1;
        }

        return left;
    }

    public int rightBound(int[] nums, int target){
        int left = 0, right = nums.length-1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }
        }

        if(right < 0 || nums[right] != target){
            return -1;
        }

        return right;
    }
}
// @lc code=end

