package DP.Pattern_Dp.MCM;

import java.util.Arrays;

public class memoiation {
    static int fun(int i,int j,int[] arr,int[][] dp){
        if (i==j) return 0;

        if (dp[i][j]!=-1)return dp[i][j];

        int min= (int) 1e9;
        for (int k=i;k<j;k++){
            int step=arr[i-1]*arr[k]*arr[j]+fun(i,k,arr,dp)+fun(k+1,j,arr,dp);
            min=Math.min(min,step);
        }
        return dp[i][j]=min;
    }

    static int matrixMultiplication(int arr[]) {
        int n=arr.length;
        int[][] dp=new int[n][n];

        for (int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(1,n-1,arr,dp);

    }
}
