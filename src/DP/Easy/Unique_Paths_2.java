package DP.Easy;

import java.util.Arrays;

public class Unique_Paths_2 {
    public int fun(int row,int col,int m,int n,int [][] dp,int [][] obstacleGrid){
        if(row==0&&col==0&&obstacleGrid[0][0]!=1) return 1;
        if(row<0|| col<0 ||obstacleGrid[row][col]==1) return 0;

        if(dp[row][col]!=-1) return dp[row][col];

        return dp[row][col]= fun(row-1,col,m,n,dp,obstacleGrid)+fun(row,col-1,m,n,dp,obstacleGrid);

    }
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;

        int [][]dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(m-1,n-1,m,n,dp,obstacleGrid);

    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;

        int [][]dp=new int[m][n];



        for (int row=0;row<m;row++){
            for (int col=0;col<n;col++){
                if(row==0&&col==0&&obstacleGrid[0][0]!=1) dp[row][col]=1;

                else if (obstacleGrid[row][col]==1) continue;

                else {
                    int left = 0, right=0;
                    if(row-1>=0){
                        left=dp[row-1][col];
                    }
                    if(col-1>=0){
                        right=dp[row][col-1];
                    }
                    dp[row][col]=left+right;

                }
            }
        }
       return dp[m-1][n-1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;

        int [][]dp=new int[m][n];

        int [] prev=new int[n];

        for (int row=0;row<m;row++){
            int[]temp= new int[n];
            for (int col=0;col<n;col++){

                if(row==0&&col==0&&obstacleGrid[0][0]!=1) temp[0]=1;

                else if (obstacleGrid[row][col]==1) temp[col]=0;

                else {
                    int left = 0, right=0;
                    if(row-1>=0){
                        left=prev[col];
                    }
                    if(col-1>=0){
                        right=temp[col-1];
                    }
                    temp[col]=left+right;

                }
            }
            prev=temp;
        }
        return prev[n-1];
    }
}
