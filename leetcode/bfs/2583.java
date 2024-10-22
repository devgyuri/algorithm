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
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> sumList = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        Queue<TreeNode> nextQueue = new ArrayDeque<>();
        long sum = 0;
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            sum += currNode.val;

            if (currNode.left != null) {
                nextQueue.offer(currNode.left);
            }
            if (currNode.right != null) {
                nextQueue.offer(currNode.right);
            }

            if (queue.isEmpty()) {
                queue = nextQueue;
                nextQueue = new ArrayDeque<>();
                sumList.add(sum);
                sum = 0;
            }
        }

        if (sumList.size() < k) {
            return -1;
        }

        Collections.sort(sumList, Collections.reverseOrder());
        return sumList.get(k - 1);
    }
}