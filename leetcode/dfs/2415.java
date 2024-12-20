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
    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(root, 0);
        return root;
    }

    private void dfs(TreeNode node, int level) {
        if (node.left == null) {
            return;
        }

        if (level % 2 == 0) {
            int temp = node.left.val;
            node.left.val = node.right.val;
            node.right.val = temp;
        }

        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}