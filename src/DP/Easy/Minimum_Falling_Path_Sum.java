package DP.Easy;

import java.util.Arrays;
import java.util.EnumMap;

public class Minimum_Falling_Path_Sum {
   public int fun1(int row,int col,int n,int[][] matrix){
        if(row==0) return matrix[row][col];
        if(row<0||row>=n||col<0||col>=n) return Integer.MAX_VALUE;

        int up=fun1(row-1,col,n, matrix);
        int uld=fun1(row-1,col-1,n,matrix);
        int urd=fun1(row-1,col+1,n,matrix);

        return matrix[row][col]+Math.min(up,Math.min(uld,urd));
    }
    public int minFallingPathSum1(int[][] matrix) {
       int n=matrix.length;
       int min=Integer.MAX_VALUE;
       for (int i=0;i<matrix[n-1].length;i++){
           return Math.min(min,fun1(n-1,i,n,matrix));
       }
         return min;
    }

    public int fun2(int row,int col,int n,int[][] matrix,int[][] dp){
        if(row<0||row>=n||col<0||col>=n) return Integer.MAX_VALUE;
        if(row==0) return matrix[row][col];


        if(dp[row][col]!=-1) return dp[row][col];

        int up=fun2(row-1,col,n, matrix,dp);
        int uld=fun2(row-1,col-1,n,matrix,dp);
        int urd=fun2(row-1,col+1,n,matrix,dp);

        return dp[row][col]=matrix[row][col]+Math.min(up,Math.min(uld,urd));
    }
    public int minFallingPathSum2(int[][] matrix) {
        int n=matrix.length;
        int min=Integer.MAX_VALUE;

        int[][]dp=new int[n][n];

        for (int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        for (int i=0;i<n;i++){
            min= Math.min(min,fun2(n-1,i,n,matrix,dp));
        }
        return min;
    }

    public int minFallingPathSum3(int[][] matrix) {
        int n = matrix.length;


        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }

        for (int row = 1; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int up = dp[row - 1][col];
                int uld = col - 1 < 0 ? Integer.MAX_VALUE : dp[row - 1][col - 1];
                int urd = col + 1 >= n ? Integer.MAX_VALUE : dp[row - 1][col + 1];

                dp[row][col] = matrix[row][col] + Math.min(up, Math.min(uld, urd));
            }
        }
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min=Math.min(min,dp[n-1][i]);
        }
        return min;
    }


    public int minFallingPathSum4(int[][] matrix) {
        int n = matrix.length;

        int[]prev = new int[n];

        for (int i = 0; i < n; i++) {
            prev[i] = matrix[0][i];
        }

        for (int row = 1; row < n; row++) {
            int []temp=new int[n];
            for (int col = 0; col < n; col++) {
                int up = prev[col];
                int uld = col - 1 < 0 ? Integer.MAX_VALUE : prev[col - 1];
                int urd = col + 1 >= n ? Integer.MAX_VALUE : prev[col + 1];

                temp[col] = matrix[row][col] + Math.min(up, Math.min(uld, urd));
            }
            prev=temp;
        }
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min=Math.min(min,prev[i]);
        }
        return min;
    }




}
