package DP;

import java.util.Arrays;

public class Minimum_Path_Sum {
    public int fun1(int row,int col,int [][] grid){
        if(row==0&&col==0) return grid[0][0];

        if(row<0||col<0)return Integer.MAX_VALUE;

        int left=fun1(row-1,col,grid);
        int right=fun1(row,col-1,grid);

        return grid[row][col]+Math.min(left,right);
    }
    public int minPathSum1(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        return fun1(m-1,n-1,grid);
    }

    public int fun2(int row,int col,int [][] grid,int [][]dp){
        if(row==0&&col==0) return grid[0][0];

        if(row<0||col<0)return Integer.MAX_VALUE;

        if (dp[row][col]!=-1) return dp[row][col];

        int left=fun2(row-1,col,grid,dp);
        int right=fun2(row,col-1,grid,dp);

        return dp[row][col]=grid[row][col]+Math.min(left,right);
    }
    public int minPathSum2(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int [][]dp=new int[m][n];
        for(int i=0;i<m+1;i++){
            Arrays.fill(dp[i],-1);
        }

        return fun2(m-1,n-1,grid,dp);
    }

    public int minPathSum3(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int [][]dp=new int[m][n];


       for (int row=0;row<m;row++){
           for (int col=0;col<n;col++){
               if(row==0&&col==0) dp[0][0]=grid[0][0];
               else {



                   int left=row-1<0?Integer.MAX_VALUE:dp[row-1][col];
                   int right=col-1<0?Integer.MAX_VALUE:dp[row][col-1];

                   dp[row][col]= grid[row][col]+Math.min(left,right);
               }
           }
       }
       return dp[m-1][n-1];
    }

    public int minPathSum4(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int []prev=new int[n];


        for (int row=0;row<m;row++){
            int []temp=new int[n];
            for (int col=0;col<n;col++){
                if(row==0&&col==0) temp[0]=grid[0][0];
                else {



                    int left=row-1<0?Integer.MAX_VALUE:prev[col];
                    int right=col-1<0?Integer.MAX_VALUE:temp[col-1];

                    temp[col]= grid[row][col]+Math.min(left,right);
                }
            }
            prev=temp;
        }
        return prev[n-1];
    }



}
