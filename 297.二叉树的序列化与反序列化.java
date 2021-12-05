/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    String SEP = ",";
    String NULL = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        return serialize(root, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> nodes = Arrays.asList(data.split(SEP));
        return deserialize(new LinkedList(nodes));
    }


    private String serialize(TreeNode root, StringBuilder sb) {
        if(root == null){
            return NULL;
        }

        sb.append(serialize(root.left)).append(SEP);
        sb.append(serialize(root.right)).append(SEP);
        sb.append(root.val);

        return sb.toString();
    }

    private TreeNode deserialize(LinkedList<String> nodes) {
        if(nodes.isEmpty()){
            return null;
        }

        String rootVal = nodes.pollLast();
        if(NULL.equals(rootVal)){
            return null;
        }

        // 先构造右子树，后构造左子树
        TreeNode right = deserialize(nodes);

        TreeNode left = deserialize(nodes);

        TreeNode root = new TreeNode(Integer.valueOf(rootVal));
        root.left = left;
        root.right = right;

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

