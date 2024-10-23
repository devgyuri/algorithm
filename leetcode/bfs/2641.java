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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<Integer> levelSum = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                sum += currNode.val;

                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
            levelSum.add(sum);
        }
    }
}