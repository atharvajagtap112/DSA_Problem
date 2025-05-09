package Binary_Search_Tree;

import java.util.Stack;

public class Binary_Search_Tree_Iterator {


    class BSTIterator {
        Stack<TreeNode> stack=new Stack<>();
        public BSTIterator(TreeNode root) {

        }

        public int next() {
          TreeNode node=stack.pop();
          push(node.right);
          return node.val;
        }

        public boolean hasNext() {
          return !stack.isEmpty();
        }

      public  void push(TreeNode node){
            for ( ;node!=null; stack.push(node), node=node.left);
      }
    }
}
