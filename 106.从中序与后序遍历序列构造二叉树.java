/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1,
                     postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd,
                           int[] postorder, int postStart, int postEnd) {
        if(inStart > inEnd || postStart > postEnd){
            return null;
        }

        // 1、找到根节点（后续遍历的最后一个）
        int rootVal = postorder[postEnd];

        // 2、定位根节点在中序数组中的位置
        int rootIdx = 0;
        for(int i = inStart; i <= inEnd; i++){
            if(inorder[i] == rootVal){
                rootIdx = i;
                break;
            }
        }

        // 3、构造根节点
        TreeNode root = new TreeNode(rootVal);

        // 4、构造根节点的左右子树
        int leftSize = rootIdx - inStart;
        root.left = build(inorder, inStart, rootIdx - 1,
                          postorder, postStart, postStart + leftSize - 1);
        root.right = build(inorder, rootIdx + 1, inEnd,
                          postorder, postStart + leftSize, postEnd - 1);

        return root;
    }
}
// @lc code=end

