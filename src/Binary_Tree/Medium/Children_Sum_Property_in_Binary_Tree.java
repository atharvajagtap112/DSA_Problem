package Binary_Tree.Medium;

public class Children_Sum_Property_in_Binary_Tree {
    public static void changeTree(Node node){
        if(node==null) return;

        int total=0;
        if(node.left!=null){
            total+=node.left.data;
        }
        if(node.right!=null){
            total+=node.right.data;
        }
        if(total<node.data) {
            node.left.data=node.data;
            node.right.data=node.data;
        }

        changeTree(node.left);
        changeTree(node.right);

        int t=0;
        if(node.left!=null){
            t+=node.left.data;
        }
        if(node.right!=null){
            t+=node.right.data;
        }

        if(node.left!=null||node.right!=null)
           node.data=t;

    }
}
