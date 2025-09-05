package DP.Subsequence.Coin_Change;

import java.util.Arrays;

public class memoiation {
    public int fun(int ind,int target,int[] coins,int[][]dp){

        if (ind==0){
            if (target%coins[ind]==0)return target/coins[ind];
            return (int)1e9;
        }
        if (dp[ind][target]!=-1)return dp[ind][target];

        int notTake=0+fun(ind-1,target,coins,dp);
        int take=(int) 1e9;
        if (coins[ind]<=target){
            take=1+fun(ind,target-coins[ind],coins,dp);
        }
        return dp[ind][target]= Math.min(notTake,take);
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for (int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        int ans=fun(n-1,amount,coins,dp);
        if (ans>=1e9)return -1;
        return ans;
    }
}
