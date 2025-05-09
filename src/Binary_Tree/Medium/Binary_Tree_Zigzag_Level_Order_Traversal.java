package Binary_Tree.Medium;

import com.sun.source.tree.Tree;

import java.util.*;

public class Binary_Tree_Zigzag_Level_Order_Traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
         List<List<Integer>> ans=new ArrayList<>();
         int flag=0; //0 left to right and 1 = right to left
         queue.add((root));
         while (!queue.isEmpty()){
             int size=queue.size();
             List<Integer> list=new ArrayList<>();
             for (int i=0;i<size;i++){
                 TreeNode node=queue.poll();
                 list.add(node.val);
                 if(node.left!=null) queue.add(node.left);
                 if(node.right!=null) queue.add(node.right);
             }

             if(flag==1) Collections.reverse(list);
             flag=flag==1? 0:1;
             ans.add(list);
         }

         return ans;
    }
}
