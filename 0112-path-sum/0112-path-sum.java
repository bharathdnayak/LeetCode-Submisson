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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root,targetSum);
    }

    boolean helper(TreeNode root,int rem){
        if (root == null) {
            return false;
        }
        int cur=root.val;
        int remain=rem-cur;
        if (root.left == null && root.right == null) {
            return remain == 0;
        }
       
        return helper(root.left,remain) || helper(root.right,remain);
    }
}