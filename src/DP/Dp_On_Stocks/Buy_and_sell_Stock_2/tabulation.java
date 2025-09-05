package DP.Dp_On_Stocks.Buy_and_sell_Stock_2;

public class tabulation {

    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n+1][2];

        for (int i=n-1;i>=0;i--){
            for (int buy=0;buy<=1;buy++){
                if (buy==1){
                     dp[i][buy] = Math.max( -prices[i]+dp[i+1][0] , dp[i+1][1] );
                }
                else  dp[i][buy]= Math.max(  prices[i]+dp[i+1][1] , dp[i+1][0] );
            }
        }

        return dp[0][1];
    }
}
