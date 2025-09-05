package DP.Dp_On_Stocks.Best_Time_to_Buy_and_Sell_Stock_4;

public class tabulation {

    int  fun(int ind,int buy,int k ,int[]prices,int [][] dp){
        if ( buy%2==0 && buy/2==k) return 0;

        if (ind==prices.length)return 0;

        if (dp[ind][buy]!=-1) return dp[ind][buy];

        if (buy%2==0){
            return dp[ind][buy] = Math.max(-prices[ind]+fun(ind+1,buy+1,k, prices,dp),fun(ind+1,buy,k,prices,dp));
        }
        else return dp[ind][buy]= Math.max(prices[ind]+fun(ind+1,buy+1,k,prices,dp),fun(ind+1,buy,k,prices,dp));
    }
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int cap=2*k;
        int[][] dp=new int[n+1][cap+1];



        for (int ind=n-1;ind>=0;ind--){
            for (int buy=cap-1;buy>=0;buy--){
                if (buy%2==0){
                     dp[ind][buy] = Math.max(-prices[ind]+dp[ind+1][buy+1],dp[ind+1][buy]);
                }
                else  dp[ind][buy]= Math.max(prices[ind]+dp[ind+1][buy+1],dp[ind+1][buy]);
            }
        }

        return dp[0][0];
    }
}
