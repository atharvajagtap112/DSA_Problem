package Binary_Tree.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class Children_Sum_in_a_Binary_Tree {
    public static int isSumProperty(Node root) {
        if(root.left==null&&root.right==null) return 0;
        Queue<Node> queue=new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            for (int i=0;i<size;i++){
                Node currNode=queue.peek();
                int leftVal=0;
                int rightVal=0;

                if(currNode.left!=null){
                    queue.add(currNode.left);
                    leftVal=currNode.left.data;
                }
                if(currNode.right!=null){
                    queue.add(currNode.right);
                    rightVal=currNode.right.data;
                }

                if(currNode.left!=null||currNode.right!=null&& leftVal+rightVal!= currNode.data) return 0;

            }
        }
        return 1;

    }
}
