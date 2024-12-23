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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> levelValues = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                levelValues.add(curr.val);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            ans += calculateMinSwap(levelValues);
        }
        return ans;
    }

    private int calculateMinSwap(ArrayList<Integer> values) {
        List<Integer> sortedValues = (ArrayList<Integer>) values.clone();
        Collections.sort(sortedValues);

        int n = values.size();
        int swapCnt = 0;
        for (int i = 0; i < n; i++) {
            if (values.get(i) == sortedValues.get(i)) {
                continue;
            }

            for (int j = 0; j < n; j++) {
                if (values.get(j) == sortedValues.get(i)) {
                    swap(values, i, j);
                    swapCnt++;
                }
            }
        }
        return swapCnt;
    }

    private void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}