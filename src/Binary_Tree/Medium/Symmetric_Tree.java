package Binary_Tree.Medium;

public class Symmetric_Tree {
    public boolean isSymmetric(TreeNode root) {
       return isSymmetric(root.left,root.right);
    }
    public boolean isSymmetric(TreeNode left,TreeNode right){
        if(left==null|| right==null){
            return left==right;
        }

        if(left.val!=right.val){
            return false;
        }

        return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
    }
}
