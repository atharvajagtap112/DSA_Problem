package Binary_Search_Tree;

public class Largest_BST {
     class Node
 {
     int data;
     Node left, right;

         public Node(int d)
     {
         data = d;
         left = right = null;
     }
 }

 class newNode{
         int sum;
         int maxNode;
         int minNode;

     public newNode(int sum, int maxNode, int minNode) {
         this.sum = sum;
         this.maxNode = maxNode;
         this.minNode = minNode;
     }
 }
     int largestBst(Node root){
        newNode node=largestBstHelper(root);

        return node.sum;
    }

    private  newNode largestBstHelper(Node root) {
         if (root==null){
             return new newNode(0,Integer.MIN_VALUE,Integer.MAX_VALUE);
         }
        newNode leftNode= largestBstHelper(root.left);
        newNode rightNode= largestBstHelper(root.right);

         if(leftNode.maxNode<root.data&&root.data<rightNode.minNode){
             return new newNode(1+leftNode.sum+rightNode.sum, Math.max(root.data, rightNode.maxNode), Math.min(root.data,leftNode.minNode));
         }

         return new newNode(Math.max(leftNode.sum,rightNode.sum), Integer.MAX_VALUE,Integer.MIN_VALUE);
    }
}
