/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length);
    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        if(start == end){
            return null;
        }

        // 1、找到最大值
        int max = 0, idx = start;
        for(int i = start; i < end; i++){
            if(nums[i] > max){
                max = nums[i];
                idx = i;
            }
        }

        // 2、构造根节点
        TreeNode root = new TreeNode(max);

        // 3、开始构建左右子树
        root.left = buildTree(nums, start, idx);
        root.right = buildTree(nums, idx + 1, end);

        return root;
    }
}
// @lc code=end

