/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
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

    int count = 0;
    int result = 0;

    // 中序遍历[左->根->右]对于BST来说就是升序
    public int kthSmallest(TreeNode root, int k) {
         traverse(root, k);
         return result;
    }

    private void traverse(TreeNode root, int k){
        if(root == null){
            return;
        }

        traverse(root.left, k);

        count++;
        if(count == k){
            result = root.val;
            return;
        }

        traverse(root.right, k);
    }
}
// @lc code=end

