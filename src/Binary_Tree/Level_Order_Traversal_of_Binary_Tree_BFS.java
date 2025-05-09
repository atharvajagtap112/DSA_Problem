package Binary_Tree;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Level_Order_Traversal_of_Binary_Tree_BFS {

    List<List<Integer>> levelOrder(Node root){
        Queue<Node> queue=new LinkedList<Node>();

        List<List<Integer>> ans=new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> list=new ArrayList<>();
            for (int i=1;i<=size;i++) {


                Node node = queue.poll();
                list.add(node.data);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            ans.add(list);
        }
        return ans;
    }
}
