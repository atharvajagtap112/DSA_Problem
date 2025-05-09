package Binary_Tree.Hard;

import Binary_Tree.Medium.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Burning_Tree {
    public static void markParentNode(HashMap<Node, Node> markParent, Node root) {
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            for (int i=0;i<size;i++){
                Node node=queue.poll();

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

   static Node getTargetNode(Node root, int target){
        if(root==null) return root;
        if(root.data==target) return root;

        Node left=getTargetNode(root.left,target);
        Node right=getTargetNode(root.right,target);

        return left!=null? left:right;
    }
    public static int minTime(Node root, int target) {
     HashMap<Node,Node> getParent=new HashMap<>();
        markParentNode(getParent,root);

        Node targetNode=getTargetNode(root,target);

        HashMap<Node,Boolean > visited=new HashMap<>();
        Queue<Node> queue=new LinkedList<>();
        queue.offer(targetNode);
        int currSec=0;
        while (!queue.isEmpty()){
            int size=queue.size();
            boolean isSatisfy=false;
            for (int i=0;i<size;i++){
                Node node=queue.poll();

                if(node.left!=null&&visited.get(node.left)==null){
                    queue.add(node.left);
                    visited.put(node.left,true);
                }
                if(node.right!=null&&visited.get(node.right)==null){
                    queue.add(node.right);
                    visited.put(node.right,true);
                }
                if(getParent.get(node)!=null&visited.get(getParent.get(node))==null){
                    queue.add(getParent.get(node));
                    visited.put(getParent.get(node),true);
                }

                if((node.left!=null&&visited.get(node.left)==null) ||(node.right!=null&&visited.get(node.right)==null) || (getParent.get(node)!=null&visited.get(getParent.get(node))==null) ){
                    isSatisfy=true;
                }
            }
          if(isSatisfy)
            currSec++;
        }
        return currSec;
    }
}
