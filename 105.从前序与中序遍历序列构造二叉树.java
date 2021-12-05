/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return build(preorder, 0, preorder.length - 1, 
                     inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }

        // 1、定位根节点（前序遍历第一个就是根节点）
        int rootVal = preorder[preStart];
        // 2、找到中序遍历中根节点位置
        int rootIdx = inStart;
        for(int i = inStart; i <= inEnd; i++){
            if(inorder[i] == rootVal){
                rootIdx = i;
                break;
            }
        }

        // 3、构造根节点
        TreeNode root = new TreeNode(rootVal);

        // 4、构造左右子树
        int leftSize = rootIdx - inStart;
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                          inorder, inStart, rootIdx - 1);

        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                          inorder, rootIdx + 1, inEnd);

        return root;
    }
}
// @lc code=end

