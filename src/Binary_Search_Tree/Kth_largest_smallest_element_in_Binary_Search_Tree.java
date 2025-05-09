package Binary_Search_Tree;

public class Kth_largest_smallest_element_in_Binary_Search_Tree {

    public void reverseInorder(TreeNode root, int [] counter, int k, int [] ans){
        if(root==null) return;

        inorder(root.right,counter,k,ans);

        counter[0]++;
        if(counter[0]==k){
            ans[0]=root.val;
            return;
        }
        inorder(root.left,counter,k,ans);
    }
    public int kthLargest(TreeNode root, int k) {
        if(root==null) return -1;
        int [] ans=new int[1];
        reverseInorder(root,new int[1],k,ans);
        return ans[0];

    }

    public void inorder(TreeNode root, int [] counter, int k, int [] ans){
        if(root==null) return;

        inorder(root.left,counter,k,ans);

        counter[0]++;
        if(counter[0]==k){
            ans[0]=root.val;
            return;
        }
       
        inorder(root.right,counter,k,ans);

    }
    public int kthSmallest(TreeNode root, int k) {
       if(root==null) return -1;
       int [] ans=new int[1 ];
       inorder(root,new int[1],k,ans);
       return ans[0];

    }
}
