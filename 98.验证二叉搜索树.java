/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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

    // 不能只判断当前根节点左右子节点的大小，而是判断根节点左子树和右子树中节点的大小
    public boolean isValidBST(TreeNode root) {

        return isValidBST(root, null, null);
    }

    // minVal和maxVal是当前root节点的取值范围
    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if(root == null){
            return true;
        }

        // 左子树必须小于其根节点的值，但是必须大于根节点的父节点的值
        boolean leftValid = isValidBST(root.left, min ,root);

        boolean rightValid = isValidBST(root.right, root ,max);

        boolean rootValid = (min != null && root.val <= min.val) || (max != null && root.val >= max.val);

        return !rootValid && leftValid && rightValid;
    }
}
// @lc code=end

