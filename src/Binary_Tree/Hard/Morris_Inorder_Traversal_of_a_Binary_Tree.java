package Binary_Tree.Hard;

import java.util.ArrayList;
import java.util.List;
public class Morris_Inorder_Traversal_of_a_Binary_Tree {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        TreeNode curr=root;
        while (curr!=null){
            if(curr.left==null){
                ans.add(curr.val); //Adding root and moving to right
                curr=curr.right;
            }
            else {
                TreeNode prev=curr.left;
                while (prev.right!=null&&prev.right!=curr){
                    prev=prev.right;
                }
                if(prev.right==null){
                    prev.right=curr;
                    curr=curr.left;  //Moving from root to left
                }
                else {
                    prev.right=null;
                    ans.add(curr.val); //Adding Root and moving Right
                    curr=curr.right;
                }
            }
        }
        return ans;
    }

    }
