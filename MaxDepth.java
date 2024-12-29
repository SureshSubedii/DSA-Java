// 104. Maximum Depth of Binary Tree
class MaxDepth {
    public int maxDepth(TreeNode root) {
        return traverseTree(root);
        
    }

    public int traverseTree(TreeNode root){
        if(root == null) return 0;
        int left = traverseTree(root.left);
        int right = traverseTree(root.right);
        int returnValue = left;
        if(right > left) returnValue = right;
        return returnValue + 1;


    }
}
