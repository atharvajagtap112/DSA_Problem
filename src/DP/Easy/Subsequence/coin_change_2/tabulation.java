package DP.Easy.Subsequence.coin_change_2;

import java.util.Arrays;

public class tabulation {
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

         for (int target=0;target<=amount;target++){
             if(target%coins[0]==0) dp[0][target]= 1;
             else dp[0][target]= 0;
         }

         for (int ind=1;ind<n;ind++){
             for (int target=0;target<=amount;target++){

                 int notTake=0+dp[ind-1][target];
                 int take=0;
                 if(target>=coins[ind]){
                     take=dp[ind][target-coins[ind]];
                 }
                  dp[ind][target]= take+notTake;

             }
         }
         return dp[n-1][amount];
    }
}
