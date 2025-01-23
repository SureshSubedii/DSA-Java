class BfsTraversal {
    class TreeNodeWithLevel {
        TreeNode node;
        int level;

        TreeNodeWithLevel(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }

        Queue<TreeNodeWithLevel> queue = new LinkedList<>();
        result.add(new ArrayList<>(List.of(root.val))); 
        queue.add(new TreeNodeWithLevel(root, 0));

        while (!queue.isEmpty()) {
            TreeNodeWithLevel currentTree = queue.poll();
            TreeNode node = currentTree.node;
            int currentLevel = currentTree.level + 1;

            if (node.left != null) {
                if (currentLevel < result.size()) {
                    result.get(currentLevel).add(node.left.val);
                } else {
                    result.add(new ArrayList<>(List.of(node.left.val)));
                }
                queue.add(new TreeNodeWithLevel(node.left, currentLevel));
            }

            if (node.right != null) {
                if (currentLevel < result.size()) {
                    result.get(currentLevel).add(node.right.val);
                } else {
                    result.add(new ArrayList<>(List.of(node.right.val)));
                }
                queue.add(new TreeNodeWithLevel(node.right, currentLevel));
            }
        }

        return result;
    }
}