package Leetcode_DailyChanllenge;

public class Last_Day_Where_You_Can_Still_Cross {
    public static int latestDayToCross(int row, int col, int[][] cells) {
      int[][] mat=new int[row+1][col+1];
      for (int i=0;i<cells.length;i++){
          mat[cells[i][0]][cells[i][1]]=i+1;

      }

      int low=1;
      int high=row*col;

      while (low<=high){
          int mid=low+(high-low)/2;

          boolean[][] visi=new boolean[row+1][col+1];
           boolean isTrue=false;
          for (int i=1;i<col+1;i++){
              if (mat[1][i]>mid&& !visi[1][i]&& dfs(1,i,mat,visi,mid)){
               isTrue=true;
               break;
              }
          }
          if (isTrue){
              low=mid+1;
          }
          else high=mid-1;
      }
      return low-1;

    }

    private static boolean dfs(int r, int c, int[][] mat, boolean[][] visi,int day) {
        int n=mat.length;
        int m=mat[0].length;
        if (r==mat.length-1) return true;
        visi[r][c]=true;

        int[][] dl={{0,-1},{0,1},{-1,0},{1,0}};
        for (int[] pair:dl){
            int newR=r+pair[0];
            int newC=c+pair[1];
            if(newR>=1&&newR<n&&newC>=1&&newC<m&&!visi[newR][newC]){
                if(day<mat[newR][newC]){
                    return dfs(newR,newC,mat,visi,day);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(latestDayToCross( 2,2,new int[][]{{1,1},{2,1},{1,2},{2,2} }));
    }
}
