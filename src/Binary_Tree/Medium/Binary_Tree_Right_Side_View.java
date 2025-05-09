package Binary_Tree.Medium;

import java.util.*;

public class Binary_Tree_Right_Side_View {
    class Pair{
        int level;
        TreeNode node;

        public Pair(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
       List<Integer> ans=new ArrayList<>();
          getRightSideView(root, 0, ans);
       return ans;
    }

    private void getRightSideView(TreeNode root, int level, List<Integer> ans) {
       if(root==null)
           return;

       if(level==ans.size()){
           ans.add(root.val);
       }
       getRightSideView(root.right,level+1,ans);
       getRightSideView(root.left,level+1,ans);

    }


//    public List<Integer> rightSideView(TreeNode root) {
//        Queue<Pair> queue=new LinkedList<>();
//        List<Integer> ans=new ArrayList<>();
//        TreeMap<Integer,TreeNode> map=new TreeMap();
//
//        queue.add(new Pair(0, root));
//        while (!queue.isEmpty()){
//            int size=queue.size();
//
//            for (int i=0;i<size;i++){
//                Pair pair=queue.poll();
//                TreeNode node=pair.node;
//                int curLevel=pair.level;
//
//                if(!map.containsKey(curLevel)){
//                    map.put(curLevel,node);
//                }
//
//                if(node.right!=null){
//                    queue.add(new Pair(curLevel+1,node.right));
//                }
//                if(node.left!=null){
//                    queue.add(new Pair(curLevel+1,node.left));
//                }
//
//
//            }
//        }
//        for (TreeNode node:map.values()){
//            ans.add(node.val);
//        }
//        return ans;
//    }
}
