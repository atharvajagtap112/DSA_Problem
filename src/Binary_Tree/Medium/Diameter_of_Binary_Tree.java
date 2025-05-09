package Binary_Tree.Medium;

public class Diameter_of_Binary_Tree {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter=new int[1];
             getMaxDepth(root,root,diameter);
         return diameter[0];
    }
    private int getMaxDepth(TreeNode node,TreeNode root, int[] diamter) {
        if (node==null) return 0;

        int lh=getMaxDepth(node.left,root,diamter);
        int rh=getMaxDepth(node.right,root,diamter);

        diamter[0]=Math.max(diamter[0],lh+rh);
        return Math.max(lh,rh);
    }
}
