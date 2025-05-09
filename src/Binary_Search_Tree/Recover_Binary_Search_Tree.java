package Binary_Search_Tree;

public class Recover_Binary_Search_Tree {

    TreeNode first;
    TreeNode last;
    TreeNode middle;
    TreeNode prev;


    private void inorder(TreeNode root) {
        if(root==null) {
            return;
        }
        inorder(root.left);
         if(prev!=null&&prev.val> root.val) {
             if(first==null){
                 first=prev;
                 middle=root;
             }
             else {
                 last=root;
             }
         }
         else prev=root;

        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        first =middle=last=null;
        prev=new TreeNode(Integer.MIN_VALUE);
       inorder(root);

       if(last!=null){
           int temp= first.val;
           first.val= last.val;
           last.val=temp;
       }
       else {
           int temp= first.val;
           first.val= middle.val;
           middle.val=temp;
       }

    }
}
