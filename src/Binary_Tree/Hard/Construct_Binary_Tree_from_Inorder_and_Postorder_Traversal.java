package Binary_Tree.Hard;

import java.util.HashMap;
import java.util.TreeMap;

public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

            HashMap<Integer, Integer >map=new HashMap<>();
            for (int i=0;i<inorder.length;i++){
                map.put(inorder[i],i);
            }

            TreeNode root=buildTree(postorder,inorder,map, 0, postorder.length-1,0,inorder.length-1);
            return root;

    }

    public TreeNode buildTree(
            int[] postOrder, int[] inOrder,HashMap<Integer,Integer> map,int inStart, int inEnd ,int postStart, int postEnd ) {

        if(inStart>inEnd || postStart>postEnd) return null;

        int inRoot=map.get(postOrder[postEnd]);
        int numLeft=inRoot-inStart;

        TreeNode root=new TreeNode(postOrder[postEnd]);
        root.left=buildTree(postOrder,inOrder,map, inStart,inRoot-1, postStart, postStart+numLeft-1);

        root.right=buildTree(postOrder,inOrder,map, inRoot+1,inEnd, postStart+numLeft, postEnd-1);
        return root;
    }


}
