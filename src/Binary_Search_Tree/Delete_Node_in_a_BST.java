package Binary_Search_Tree;

public class Delete_Node_in_a_BST {
    public TreeNode deleteNode(TreeNode root, int key) {
     if(root==null){
         return null;
     }

     if(root.val==key) {
         return helper(root);
     }
     TreeNode dummy=root;
     while (dummy!=null){
         if(dummy.val>key){
             if(dummy.left!=null&&dummy.left.val==key){
                 dummy.left=helper(dummy.left);
                 break;
             }
             else dummy=dummy.left;
         }
         else {
             if(dummy.right!=null&&dummy.right.val==key ){
                 dummy.right=helper(dummy.right);
             }
             else dummy=dummy.right;
         }
     }
     return root;
    }

    private TreeNode helper(TreeNode root) {
      if(root==null) return root;
      if(root.right==null){
          return root.left;
      }
      if(root.left==null){
          return root.right;
      }


      findLastRight(root.left).right=root.right;

      return root.left;
    }

    private TreeNode findLastRight(TreeNode root) {
        if(root.right==null) return root;
        return findLastRight( root.right);
    }


}
