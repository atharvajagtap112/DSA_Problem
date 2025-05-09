package Binary_Tree.Medium;

public class Count_Complete_Tree_Nodes {
    public int countNodes(TreeNode root) {
       if(root==null) return 0;
       int lh=getLeftHeight(root);
       int rh=getRightHeight(root);
       if(lh==rh) return (2<<lh)-1;

       return 1+countNodes(root.left)+countNodes(root.right);
    }

    private int getRightHeight(TreeNode root) {
        int height=0;
        while (root!=null){
            height++;
            root=root.right;
        }
        return height;
    }

    private int getLeftHeight(TreeNode root) {
        int height=0;
        while (root!=null){
            height++;
            root=root.left;
        }
        return height;
    }


}
