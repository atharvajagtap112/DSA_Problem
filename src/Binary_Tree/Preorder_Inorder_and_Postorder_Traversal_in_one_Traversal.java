package Binary_Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Preorder_Inorder_and_Postorder_Traversal_in_one_Traversal {

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

    class Pair{
        TreeNode node;
        int num;

        public Pair(TreeNode node, int num) {
            this.node = node;
            this.num = num;
        }
    }
    public void PreInPostTraversal(TreeNode root){
        Stack<Pair> stack =new Stack();
        stack.push(new Pair(root,1));
        List<Integer> pre=new ArrayList<>();
        List<Integer> in=new ArrayList<>();
        List<Integer> post=new ArrayList<>();
        while (!stack.isEmpty()){

            Pair pair=stack.pop();

            if (pair.num==1){
                pre.add(pair.node.val);
                pair.num++;
                stack.push(pair);
                if (pair.node.left!=null){
                    stack.push(new Pair(pair.node.left,1));
                }
            }

            else if(pair.num==2){
                in.add(pair.node.val);
                pair.num++;
                stack.push(pair);
                if (pair.node.right!=null){
                    stack.push(new Pair(pair.node.right,1));
                }
            }

            else post.add(pair.node.val);
        }
    }
}
