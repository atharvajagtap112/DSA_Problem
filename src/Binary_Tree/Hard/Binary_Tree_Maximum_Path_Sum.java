package Binary_Tree.Hard;

public class Binary_Tree_Maximum_Path_Sum {
    public int maxPathSum(TreeNode root) {
       int [] maxPath=new int[1];
           findMaxPath(root, maxPath);
       return maxPath[0];

    }

    private int findMaxPath(TreeNode root, int[] maxPath) {
        if(root==null) return 0;
        int lh=Math.max(0,findMaxPath(root.left, maxPath));
        int rh=Math.max(0,findMaxPath(root.right, maxPath));

        maxPath[0]= root.val+lh+rh;

        return root.val+Math.max(lh,rh);
    }
}
