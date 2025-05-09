package Binary_Search_Tree;

 class Construct_Binary_Search_Tree_from_Preorder_Traversal {
     public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE, 0);
     }

     private TreeNode build(int[] preorder, int ub, int i) {
         if(i==preorder.length|| preorder[i]>ub) return null;

         TreeNode node=new TreeNode(preorder[i]);

         node.left=build(preorder,node.val,i+1);
         node.right=build(preorder,ub,i+1);
         return node;
     }
 }
