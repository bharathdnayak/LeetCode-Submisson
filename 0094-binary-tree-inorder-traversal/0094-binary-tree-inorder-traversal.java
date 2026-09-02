class Solution {
    List<Integer> inorder = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null){
            return inorder;

        }
        inorderTraversal(root.left);
        inorder.add(root.val);
        inorderTraversal(root.right);
        return inorder;
    
    }

    }
