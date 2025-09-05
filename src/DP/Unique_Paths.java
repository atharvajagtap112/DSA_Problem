package DP;

import java.util.Arrays;

public class Unique_Paths {
    public int fun(int row,int col,int m,int n,int [][] dp){
        if(row==1&&col==1) return 1;
        if(row<=0|| col<=0) return 0;

        if(dp[row][col]!=-1) return dp[row][col];

        return dp[row][col]= fun(row-1,col,m,n,dp)+fun(row,col-1,m,n,dp);

    }
    public int uniquePaths(int m, int n) {

        int [][]dp=new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            Arrays.fill(dp[i],-1);
        }

       dp[1][1]=1;

        for (int row=1;row<m+1;row++){
            for(int col=1;col<n+1;col++){
                if(row==1&&col==1) continue;
                 int left= row-1<=0? dp[row-1][col]:0;
                 int up=col-1<=0?dp[row][col-1]:0;
                dp[row][col]=left + up;
            }
        }
      return dp[m+1][n+1];
    }

    static int countWays(int m, int n) {
        // Create an array to store the results for the previous row
        int prev[] = new int[n];

        for (int i = 0; i < m; i++) {
            // Create a temporary array to store the results for the current row
            int temp[] = new int[n];

            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    // Base condition: There's one way to reach the top-left cell (0, 0)
                    temp[j] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;

                // Calculate the number of ways by moving up (if possible) and left (if possible)
                if (i > 0)
                    up = prev[j];
                if (j > 0)
                    left = temp[j - 1];

                // Store the total number of ways to reach the current cell in the temporary array
                temp[j] = up + left;
            }

            // Set the temporary array as the previous array for the next row
            prev = temp;
        }

        // Return the number of ways to reach the bottom-right cell (m-1, n-1)
        return prev[n - 1];
    }
}
