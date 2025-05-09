package Binary_Tree.Hard;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Maximum_Width_of_Binary_Tree {
    class Pair{
        int index;
        TreeNode node;

        public Pair(int index, TreeNode node) {
            this.index = index;
            this.node = node;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> queue=new LinkedList<>();
         int ans=0;
        queue.add(new Pair(0,root));

        while (!queue.isEmpty()){
            int size=queue.size();
            int min=queue.peek().index;
            int first=0;
            int last=0;
            for (int i=0;i<size;i++){
                Pair pair=queue.poll();
                int curId=pair.index-min;
                TreeNode node=pair.node;
                if(i==0) first=curId;
                if (i==size-1)last=curId;

                if (node.left!=null) {
                    queue.add(new Pair(curId*2+1, node.left));
                }
                if (node.right!=null) {
                    queue.add(new Pair(curId*2+2, node.right));
                }

            }

            ans=Math.max(ans, last-first+1);
        }
       return ans;
    }
}
