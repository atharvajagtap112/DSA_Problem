package Binary_Search_Tree;

import java.util.*;

public class Two_Sum_IV_Input_is_a_BST {


    class BSTIterator {
        Stack<TreeNode> stack=new Stack<>();
        Boolean reverse=true; // true before
        public BSTIterator(TreeNode root, Boolean reverse) {
            this.reverse=reverse;
            pushAll(root);
        }

        public int next() {
            TreeNode node=stack.pop();
            if (reverse) {
                pushAll(node.left);
            } else {
                pushAll(node.right);
            }
            return node.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public  void pushAll(TreeNode node){

            while (node!=null){
                stack.push(node);
                if(reverse) {
                    node=node.right;
                }
                else {
                    node=node.left;
                }
            }
        }
    }
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator l=new BSTIterator(root,false);
        BSTIterator r=new BSTIterator(root,true);

        int i=l.next();
        int j=r.next();
        while (i<j){
            if (i+j==k) return true;
            if(i+j<k) i=l.next();
            else j=r.next();
        }
        return false;

    }




}
