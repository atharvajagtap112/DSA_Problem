package Binary_Tree.Medium;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;



public class boundary_traversal_of_a_binary_tree {

    boolean isLeaf(TreeNode node){
        return  node.left==null&&node.right==null;
    }

    void leftboundaryTraversal(TreeNode node, List<Integer> res){
        TreeNode curr=node.left;
        while (curr!=null){
            if(!isLeaf(curr)) res.add(curr.val);
            if(curr.left!=null){
            curr=curr.left;}
            else {
                curr=curr.right;
            }

        }
    }

    void rightBoundaryTraversal(TreeNode node, List<Integer> res){
        TreeNode curr=node.right;
        ArrayList<Integer> temp=new ArrayList<>();
        while (curr!=null){
            if(!isLeaf(curr)) temp.add(curr.val);

            if(curr.right!=null){
                curr=curr.right;
            }
            else {
                curr=curr.left;
            }
        }

        for (int i=temp.size()-1;i>=0;i--){
            res.add(temp.get(i));
        }
    }

    void addLeaf(TreeNode node, List<Integer> res){
        if(isLeaf(node)) {
            res.add(node.val);
            return;
        }
        if(node.left!=null)
        addLeaf(node.left,res);
        if(node.right!=null)
        addLeaf(node.right,res);

    }

    List<Integer> printBoundary(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();

        if(root==null) return res ;
        if(isLeaf(root)) res.add(root.val);
         leftboundaryTraversal(root,res);
         addLeaf(root,res);
         rightBoundaryTraversal(root,res);
         return res;
    }
}
