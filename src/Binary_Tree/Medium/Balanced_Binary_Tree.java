package Binary_Tree.Medium;

public class Balanced_Binary_Tree {

    public boolean isBalanced(TreeNode root) {

       return dfsHeight(root)==-1?false :true;
    }

    private int dfsHeight(TreeNode root) {

        if(root==null) return 0;

        int lh=dfsHeight(root.left);
        int rh=dfsHeight(root.right);

        if (lh==-1|| rh==-1) return -1;
        if (Math.abs(lh-rh)>1) return -1;

        return 1+Math.max(lh,rh);
    }
}
