package revesion;



public class BS {
    public class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public int maxPathSum(TreeNode root) {
     int [] max=new int[1];
     max[0]=Integer.MIN_VALUE;
     int [] tempMax=new int[1];
        tempMax[0]=Integer.MIN_VALUE;
     dfs(root,max,tempMax);
     return Math.max(max[0],tempMax[0]);
    }

    private void dfs(TreeNode root, int[] max, int[] tempMax) {
        if (root==null){
            return;
        }
        dfs(root.left,max,tempMax);

        if(tempMax[0]>tempMax[0]+root.val) tempMax[0]=Integer.MIN_VALUE;
        else max[0]=Math.max(tempMax[0],max[0]);
        dfs(root.right,max,tempMax);
    }
}
