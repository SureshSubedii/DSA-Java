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

        Queue<TreeNodeWithLevel> queue = new LinkedList<>();
        if (root == null)
            return result;

        result.add(new ArrayList<>() {
            {
                add(root.val);
            }
        });
        queue.add(new TreeNodeWithLevel(root, 0));
        while (!queue.isEmpty()) {
            TreeNodeWithLevel currentTree = queue.poll();
            TreeNode treeNode = currentTree.node;
            if (treeNode == null)
                continue;
            int currentLevel = currentTree.level + 1;

            if (treeNode.left != null && treeNode.right != null) {
                if (currentLevel < result.size()) {
                    result.get(currentLevel).add(treeNode.left.val);
                    result.get(currentLevel).add(treeNode.right.val);

                } else {
                    result.add(new ArrayList<>() {
                        {
                            add(treeNode.left.val);
                            add(treeNode.right.val);
                        }
                    });
                }
                queue.add(new TreeNodeWithLevel(treeNode.left, currentLevel));
                queue.add(new TreeNodeWithLevel(treeNode.right, currentLevel));
            } else if (treeNode.left == null && treeNode.right == null)
                continue;

            else {
                addNode(treeNode.left, treeNode.right, queue, currentLevel);

            }
        }
        return result;

    }

    public void addNode(TreeNode left, TreeNode right, Queue<TreeNodeWithLevel> queue, int currentLevel) {

        if (currentLevel < result.size()) {

            if (left == null) {
                result.get(currentLevel).add(right.val);
                queue.add(new TreeNodeWithLevel(right, currentLevel));
            }

            else {
                result.get(currentLevel).add(left.val);
                queue.add(new TreeNodeWithLevel(left, currentLevel));
            }

        } else {
            if (left == null) {
                result.add(new ArrayList<>() {
                    {
                        add(right.val);
                    }
                });
                queue.add(new TreeNodeWithLevel(right, currentLevel));

            } else {
                result.add(new ArrayList<>() {
                    {
                        add(left.val);
                    }
                });
                queue.add(new TreeNodeWithLevel(left, currentLevel));

            }

        }

    }
}
