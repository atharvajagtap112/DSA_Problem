package DP.Easy.Subsequence.Knapsack_with_Duplicate_Items;

import java.util.Arrays;

public class memoiation {
    static int fun(int ind,int W,int[] val,int[] wt,int[][]dp){
        if (ind == 0) {
            return (W/wt[ind])*val[ind];
        }

        if (dp[ind][W]!=-1)return dp[ind][W];
        int notTake=0+fun(ind-1,W,val,wt,dp);
        int take=Integer.MIN_VALUE;
        if (wt[ind]<=W){
            take=val[ind]+fun(ind,W-wt[ind],val,wt,dp);
        }
        return dp[ind][W]= Math.max(notTake,take);
    }

    static int knapSack(int val[], int wt[], int capacity) {

        int n= wt.length;
        int[][] dp=new int[n][capacity+1];
        for (int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(n-1,capacity,val,wt,dp);
    }
}
