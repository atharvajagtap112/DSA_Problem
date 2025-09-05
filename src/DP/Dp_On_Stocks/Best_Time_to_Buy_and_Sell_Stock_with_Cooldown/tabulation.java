package DP.Dp_On_Stocks.Best_Time_to_Buy_and_Sell_Stock_with_Cooldown;

public class tabulation {

    public int maxProfit(int[] prices) {
        int n=prices.length+2;
        int[][] dp=new int[n][2];

        for (int i=n-3;i>=0;i--){
            for (int buy=0;buy<=1;buy++){


                if (buy==1){
                    dp[i][buy]= Math.max(-prices[i]+dp[i+1][0],dp[i+1][1]);
                }
                else  dp[i][buy]= Math.max(prices[i]+dp[i+2][1],dp[i+1][0]);
            }
        }

        return dp[0][1];

    }
}
