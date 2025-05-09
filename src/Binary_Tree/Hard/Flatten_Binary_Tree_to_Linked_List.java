package Binary_Tree.Hard;

public class Flatten_Binary_Tree_to_Linked_List {
    public void flatten(TreeNode root) {
    TreeNode curr=root;
    while (curr!=null){
        if(curr.left!=null){
            TreeNode prev=curr.left;
            while (prev.right!=null){
                prev=prev.right;
            }
            prev.right=curr.right;
            curr.right=curr.left;
        }
        curr=curr.right;
    }
    }
}
