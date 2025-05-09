package Binary_Search.Hard;

public class Find_a_Peak_Element_II {
    public int[] findPeakGrid(int[][] mat) {
      int low=0;
      int high=mat[0].length-1;
      while (low<=high){
          int col=(low+high)/2;
          int maxelerow=findMax(mat,col,mat.length);
          int left=(col-1>=0)? mat[maxelerow][col-1]:-1;
          int right =(col+1<mat[0].length)?mat[maxelerow][col+1]:-1;
          if (left<mat[maxelerow][col]&&mat[maxelerow][col]>right){
              return new int[]{maxelerow,col};
          }
          if (left>mat[maxelerow][col]) high=col-1;
          else low=col+1;
      }
      return new int[]{-1,-1};
    }

    private int findMax(int[][] arr, int col, int m) {
      int row=-1;
      int max=0;
      for (int i =0;i<m;i++){
          if (max<arr[i][col]){
              max=arr[i][col];
              row=i;
          }
      }
      return row;
    }
}
