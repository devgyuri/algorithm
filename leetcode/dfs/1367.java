/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        return dfs(head, head, root);
    }

    private boolean dfs(ListNode head, ListNode curr, TreeNode root) {
        if (curr == null) {
            return true;
        }
        if (root == null) {
            return false;
        }

        if (root.val == curr.val) {
            return dfs(head, curr.next, root.left) || dfs(head, curr.next, root.right);
        } else if(curr != head) {
            return dfs(head, head, root);
        }
        return dfs(head, head, root.left) || dfs(head, head, root.right);
    }
}