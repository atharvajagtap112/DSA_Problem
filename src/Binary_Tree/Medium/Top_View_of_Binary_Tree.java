package Binary_Tree.Medium;



import java.util.*;

public class Top_View_of_Binary_Tree {


    class Pair{
        Node node;
        int col;

        public Pair(Node node, int col) {
            this.node = node;
            this.col = col;
        }


    }
    public ArrayList<Integer> topView(Node root) {
           ArrayList<Integer> ans=new ArrayList<>();
        Queue<Pair> queue =new LinkedList<>();
        TreeMap<Integer,Integer> map=new TreeMap<>();

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()){
            int size=queue.size();
            for (int i=0;i<size;i++){
                Pair pair=queue.poll();
                int col=pair.col;
                Node node=pair.node;
                if(!map.containsKey(col)){
                    map.put(col, pair.node.data);
                }
                if(node.left!=null){
                    queue.add(new Pair(node.left,col-1));
                }
                if(node.right!=null){
                    queue.add(new Pair(node.right,col+1));
                }
            }
        }
        for (Integer val:map.values()){
            ans.add(val);
        }
        return ans;
    }
}
