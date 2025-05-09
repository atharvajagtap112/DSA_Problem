package Binary_Tree.Medium;
import java.util.*;

public class All_Nodes_Distance_K_in_Binary_Tree {

    private void markParentNode(HashMap<TreeNode, TreeNode> markParent, TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            for (int i=0;i<size;i++){
                TreeNode node=queue.poll();

                if(node.left!=null){
                    queue.add(node.left);
                    markParent.put(node.left,node);
                }
                if(node.right!=null){
                    queue.add(node.right);
                    markParent.put(node.right,node);
                }
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> markParent=new HashMap<>();
        markParentNode(markParent,root);

        Queue<TreeNode> queue=new LinkedList();
        HashMap<TreeNode,Boolean> visited=new HashMap<>();
        queue.offer(target);
        int currLevel=0;
        visited.put(target,true);

        while(!queue.isEmpty()){
            int size=queue.size();
            if(currLevel==k){
                break;
            }

            for (int i=0;i<size;i++){
                TreeNode node=queue.poll();

                if(node.left!=null&&visited.get(node.left)){
                    queue.offer(node.left);
                    visited.put(node.left,true);
                }
                if(node.right!=null&&visited.get(node.right)){
                    queue.offer(node.right);
                    visited.put(node.right,true);
                }

                if(markParent.get(node)!=null){
                    queue.offer(markParent.get(node));
                    visited.put(markParent.get(node),true);
                }
                currLevel++;
            }
        }
          List<Integer> ans=new ArrayList<>();
           while (!queue.isEmpty()){
               ans.add(queue.poll().val);
           }
           return ans;
    }


}
