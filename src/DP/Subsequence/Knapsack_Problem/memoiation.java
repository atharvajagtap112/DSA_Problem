package DP.Subsequence.Knapsack_Problem;

import java.util.Arrays;

public class memoiation {
    static int fun(int ind,int W,int[] wt,int[] val,int [][]dp){

        if (ind==0){
            if (wt[0]<=W) return val[ind];
            else return 0;
        }
        if (dp[ind][W]!=-1)return dp[ind][W];

        int notTake=fun(ind-1,W,wt,val,dp);
        int take=Integer.MIN_VALUE;
        if (wt[ind]<=W){
            take=val[ind]+fun(ind-1,W-wt[ind],wt,val,dp);
        }
        return dp[ind][W]= Math.max(notTake,take);
    }
    static int knapsack(int W, int val[], int wt[]) {
        int n=wt.length;
         int[][] dp=new int[n][W+1];
          for (int i=0;i<n;i++){
              Arrays.fill(dp[i], -1);
          }

        return fun(wt.length-1,W,wt,val ,dp);

    }
}
