package DP.Easy.Subsequence.coin_change_2;

import java.util.Arrays;

public class memoiation {
    public int fun(int ind,int target,int[] coins,int[][]dp){
        if(ind==0){
            if(target%coins[0]==0) return 1;
            return 0;
        }

        if (dp[ind][target]!=-1)return dp[ind][target];

        int notTake=0+fun(ind-1,target,coins,dp);
        int take=0;
        if(target>=coins[ind]){
            take=fun(ind,target-coins[ind],coins,dp);
        }
        return dp[ind][target]= take+notTake;
    }

    public int change(int amount, int[] coins) {
        int n=coins.length;
        int [][]dp= new int[n][amount+1];
        for (int i=0;i<n;i++){
           Arrays.fill(dp[i],-1);
        }

        return fun(n-1,amount,coins,dp);
    }


}
