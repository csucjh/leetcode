/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
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

    // 实际上就是将节点的左子树变为其右子树，然后将原右子树连接到新的右子树下
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode right = root.right;

        // 左子树变为右子树
        root.right = root.left;
        root.left = null;

        // 原右子树连接到新的右子树
        TreeNode p = root;
        while(p.right != null){
            p = p.right;
        }
        p.right = right;
    }
}
// @lc code=end

