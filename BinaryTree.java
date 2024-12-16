
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class BinaryTree {

    public TreeNode traverseTree(TreeNode root){
        if(root == null) return null;

        traverseTree(root.left);
        traverseTree(root.right);
        TreeNode rightNode = root.right;
        root.right = root.left;
        root.left =  rightNode; 
        return root;
    }
    public TreeNode invertTree(TreeNode root) {
        return  traverseTree(root);

        
    }
}
