package Binary_Tree.Medium;



public class Maximum_Depth_of_Binary_Tree {
    public class TreeNode {
        int val;
       TreeNode left;
       TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val,TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int maxDepth(TreeNode root) {
      return getMaxDepth(root, 1);
    }

    private int getMaxDepth(TreeNode node, int count) {
        if (node==null) return count;

        int leftCount=getMaxDepth(node.left,count+1);
        int rightCount=getMaxDepth(node.right,count+1);
         return Math.max(leftCount,rightCount);
    }

}
