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
    public int getMinimumDifference(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        store(root, set);

        Integer[] arr = set.toArray(new Integer[0]);

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                ans = Math.min(ans, Math.abs(arr[i] - arr[j]));
            }
        }

        return ans;
    }

    void store(TreeNode root, Set<Integer> set) {
        if (root == null) return;

        set.add(root.val);

        store(root.left, set);
        store(root.right, set);
    }
}