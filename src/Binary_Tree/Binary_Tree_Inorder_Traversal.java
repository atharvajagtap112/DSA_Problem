package Binary_Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Inorder_Traversal {
     public class TreeNode {
     int val;
      TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
        this.right = right;
      }
 }
    public List<Integer> inorderTraversal(TreeNode root) {
     Stack<TreeNode> stack=new Stack<>();
     List<Integer> ans=new ArrayList<>();
     TreeNode temp=root;
     while (true){
         while (temp!=null){
             stack.push(temp);
             temp=temp.left;
         }
         if(stack.isEmpty())break;
         TreeNode node=stack.pop();
         ans.add(node.val);
         temp=node.right;

     }
     return ans;
    }
}
