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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2 == null;
        }
        if (root2 == null) {
            return false;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root1);
        stack2.push(root2);

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode node1 = stack1.pop();
            TreeNode node2 = stack2.pop();
            if (node1.val != node2.val) {
                return false;
            }

            if (node1.left == null && node1.right == null) {
                if (node2.left != null || node2.right != null) {
                    return false;
                }
            } else if (node1.left == null && node1.right != null) {
                if (node2.left == null && node2.right == null) {
                    return false;
                } else if (node2.left != null && node2.right != null) {
                    return false;
                } else if (node2.left != null && node2.right == null) {
                    flip(node2);
                }
            } else if (node1.left != null && node1.right == null) {
                if (node2.left == null && node2.right == null) {
                    return false;
                } else if (node2.left != null && node2.right != null) {
                    return false;
                } else if (node2.left == null && node2.right != null) {
                    flip(node2);
                }
            } else if (node1.left != null && node1.right != null) {
                if (node2.left == null || node2.right == null) {
                    return false;
                }
            } else if (node1.left.val != node2.left.val) {
                flip(node2);
            }

            if (node1.left != null) {
                stack1.push(node1.left);
                stack2.push(node2.left);
            }
            if (node2.right != null) {
                stack1.push(node1.right);
                stack2.push(node2.right);
            }
        }
        return true;
    }

    private void flip(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}