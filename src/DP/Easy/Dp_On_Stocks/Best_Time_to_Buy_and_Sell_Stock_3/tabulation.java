package DP.Easy.Dp_On_Stocks.Best_Time_to_Buy_and_Sell_Stock_3;

public class tabulation {
    public int maxProfit(int[] prices) {

        int n=prices.length;
        int[][][] dp=new int[n+1][2][3];


        for (int ind=n-1;ind>=0;ind--){
            for (int buy=1;buy>=0;buy--){
                for (int cap=1;cap<=2;cap++){
                    if (buy==1){
                        dp[ind][buy][cap]= Math.max(-prices[ind]+dp[ind+1][0][cap],dp[ind+1][1][cap]);
                    }
                    else  dp[ind][buy][cap]= Math.max(prices[ind]+dp[ind+1][1][cap-1],dp[ind+1][0][cap]);
                }
            }
        }

        return  dp[0][1][2];
    }

}
