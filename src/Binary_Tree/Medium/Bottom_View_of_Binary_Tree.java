package Binary_Tree.Medium;

import java.util.*;

public class Bottom_View_of_Binary_Tree {
    class Pair{
        int col;
        Node node;

        public Pair(int col, Node node) {
            this.col = col;
            this.node = node;
        }
    }



    public ArrayList<Integer> bottomView(Node root)
    {
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<Pair> queue=new LinkedList<>();
        TreeMap<Integer,Node> map=new TreeMap<>();

        queue.add(new Pair(0,root));
        while (!queue.isEmpty()){
            int size=queue.size();
            for (int i=0;i<size;i++){
                Pair pair=queue.poll();
                Node node=pair.node;
                int col=pair.col;

                map.put(col,node);
                if(node.left!=null){
                    queue.add(new Pair(col-1,node.left  ));
                }
                if(node.right!=null){
                    queue.add(new Pair(col+1, node.right));
                }
            }
        }

        for (Node node: map.values()){
            ans.add(node.data);
        }
        return ans;
    }
}
