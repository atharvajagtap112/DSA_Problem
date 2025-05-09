package Binary_Tree.Hard;

import java.util.*;

public class Vertical_Order_Traversal_of_a_Binary_Tree {
    class Tuple{
         TreeNode node;
         int level;
         int col;
         Tuple(TreeNode node, int col, int level){
             this.node=node;
             this.level=level;
             this.col=col;
         }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
       Queue<Tuple> queue=new LinkedList<>();
        TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> map=new TreeMap();

        queue.add(new Tuple(root,0,0));
        while (!queue.isEmpty()){
          Tuple tuple=queue.poll();
          TreeNode node=tuple.node;
          int y=tuple.col;
          int x=tuple.level;

          if(!map.containsKey(y)){
              map.put(y,new TreeMap<>());
          }
          if(!map.get(y).containsKey(x))
              map.get(y).put(x,new PriorityQueue<>());

          map.get(y).get(x).add(node.val);

          if(node.left!=null)
          queue.add(new Tuple(node.left,y-1,x+1));
          if(node.right!=null)
          queue.add(new Tuple(node.right,y+1,x+1));
        }

        List<List<Integer> > ans=new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> level:map.values()){
             ans.add(new ArrayList<>());
            for (PriorityQueue<Integer> _pq: level.values()){
                while (!_pq.isEmpty()){
                    ans.get(ans.size()-1).add(_pq.poll());
                }
            }
        }
        return ans;
    }
}
