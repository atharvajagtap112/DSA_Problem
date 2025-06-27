package DP.Easy.Dp_On_Stocks.Buy_and_sell_Stock_2;

import java.util.Arrays;

public class memoiation {
    public int fun(int i,int buy,int[] prices,int[][]dp){
        if (i==prices.length)return 0;

        if (dp[i][buy]!=-1)return dp[i][buy];
        if (buy==1){
            return dp[i][buy] = Math.max(-prices[i]+fun(i+1,0,prices,dp),fun(i+1,1,prices,dp));
        }
        else return dp[i][buy]=  Math.max(prices[i]+fun(i+1,1,prices,dp),fun(i+1,0,prices,dp));
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        for (int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        return fun(0,1,prices,dp);
    }
}
