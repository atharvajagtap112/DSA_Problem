package Binary_Tree.Medium;

import java.util.HashMap;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer >map=new HashMap<>();
        for (int i=0;i<preorder.length;i++){
            map.put(inorder[i],i);
        }

        TreeNode root=buildTree(preorder,inorder,map, 0, preorder.length-1,0,inorder.length-1);
        return root;
    }

    public TreeNode buildTree(
            int[] preorder, int[] inorder,HashMap<Integer,Integer> map,int inStart, int inEnd ,int preStart, int preEnd ) {

        if(preEnd< preStart || inEnd<inStart) return null;

        int inRootIndex=map.get(preorder[preStart]);
        TreeNode root=new TreeNode(preorder[preStart]);
        int numLeft=inRootIndex-inStart;

        root.left=buildTree(preorder,inorder,map, inStart,inRootIndex-1, preStart+1,preStart+numLeft);
        root.right=buildTree(preorder,inorder,map, inRootIndex+1,inEnd,  numLeft+preStart+1,preEnd);

        return root;
    }
}
