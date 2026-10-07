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
    TreeNode head = null;
    TreeNode prev = null;

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;

        increasingBST(root.left);

        TreeNode right = root.right;

        if (prev == null) {
            head = root;
        } else {
            prev.right = root;
            prev.left = null;
        }

        root.left = null;
        prev = root;

        increasingBST(right);

        return head;
    }
}