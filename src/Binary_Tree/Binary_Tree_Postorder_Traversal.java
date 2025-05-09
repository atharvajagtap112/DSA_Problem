package Binary_Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Postorder_Traversal {
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while (cur!=null|| !stack.empty()){
            if(cur!=null) {
                stack.push(cur);
                cur=cur.left;
            }
            else {
                TreeNode temp=cur;
                if (cur==null){
                    temp= stack.pop();
                    ans.add(temp.val);
                    while (!stack.isEmpty()&&temp==stack.peek().right){
                        TreeNode node= stack.pop();
                        temp=node;
                        ans.add(node.val);
                    }
                }
                else cur=temp;

            }
        }
        return ans;
    }
}
