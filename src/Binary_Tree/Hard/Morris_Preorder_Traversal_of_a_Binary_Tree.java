package Binary_Tree.Hard;

import java.util.ArrayList;
import java.util.List;

public class Morris_Preorder_Traversal_of_a_Binary_Tree {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        TreeNode curr=root;
        while (curr!=null){
            if(curr.left==null){
                ans.add(curr.val); //Adding root and moving to right  Root Right
                curr=curr.right;
            }
            else {
                TreeNode prev=curr.left;
                while (prev.right!=null&&prev.right!=curr){
                    prev=prev.right;
                }
                if(prev.right==null){
                    prev.right=curr;
                    ans.add(curr.val);
                    curr=curr.left;  //Moving from root to left  // Root Left
                }
                else {
                    prev.right=null;
                       //From Root to Right                 //Root Right
                    curr=curr.right;
                }
            }
        }
        return ans;
    }
}
