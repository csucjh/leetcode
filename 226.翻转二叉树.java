/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
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
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        // 1、其实就是将每个节点的左右子树互换(递归公式含义)
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        // 2、后续遍历代码位置
        root.left = right;
        root.right = left;

        return root;
    }
}
// @lc code=end

