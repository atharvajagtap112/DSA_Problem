package Binary_Tree.Hard;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class Serialize_and_Deserialize_Binary_Tree {
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        StringBuilder string=new StringBuilder();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node==null){
                string.append("n ");
            continue;
            }
            else string.append(node.val+" ");

            queue.add(node.left);
            queue.add(node.right);

        }

        return string.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
     Queue<TreeNode> queue=new LinkedList<>();
     String[] arr=data.split(" ");

     TreeNode root=new TreeNode(Integer.parseInt(arr[0]));
        queue.add(root);

        for (int i=1;i<arr.length;i++){
            TreeNode node =queue.poll();
            if(!arr[i].equals("n")){
                TreeNode leftNode=new TreeNode(Integer.parseInt(arr[i]));
                node.left=leftNode;
                queue.offer(leftNode);
            }
            if(!arr[++i].equals("n")){
                TreeNode rightNode=new TreeNode(Integer.parseInt(arr[i]));
                node.right=rightNode;
                queue.offer(rightNode);
            }
        }
        return root;
    }
}
