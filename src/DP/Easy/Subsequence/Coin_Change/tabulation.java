package DP.Easy.Subsequence.Coin_Change;

import java.util.Arrays;

public class tabulation {

    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for (int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        //base case
        for (int target=0;target<=amount;target++){
            if (target%coins[0]==0)  dp[0][target]= target/coins[0];
            else dp[0][target]= (int)1e9;
        }

       for (int ind=1;ind<n;ind++){
           for (int target=0;target<=amount;target++){
               int notTake=0+dp[ind-1][target];
               int take=(int) 1e9;
               if (coins[ind]<=target){
                   take=1+dp[ind][target-coins[ind]];
               }
                dp[ind][target]= Math.min(notTake,take);
           }
       }

        if (dp[n-1][amount]>=1e9)return -1;
        return dp[n-1][amount];
    }
}
