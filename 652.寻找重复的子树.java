/*
 * @lc app=leetcode.cn id=652 lang=java
 *
 * [652] 寻找重复的子树
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

    List<TreeNode> dupSubTrees = new LinkedList<>();
    
    // map的key是序列化后的字符串，value是出现的次数
    Map<String,Integer> map = new HashMap<>(); 

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return dupSubTrees;
    }

    String SEP = ",";
    String NULL = "#";

    private String serialize(TreeNode root) {
        if(root == null){
            return NULL;
        }

        String leftSubTree = serialize(root.left);
        String rightSubTree = serialize(root.right);

        StringBuilder sb = new StringBuilder();
        sb.append(leftSubTree).append(SEP);
        sb.append(rightSubTree).append(SEP);
        sb.append(root.val);


        String subTree = sb.toString();
        int cnt = map.getOrDefault(subTree, 0);
        // 只有历史出现次数为1时，此次才是第二次出现，再下次就是第三次出现了，不重复计算
        if(cnt == 1){
            dupSubTrees.add(root);
        }

        map.put(subTree, cnt + 1);

        return subTree;
    }

}
// @lc code=end

