package DP.Easy.Dp_On_Stocks.Best_Time_to_Buy_and_Sell_Stock_3;

public class memoiation {
    public int fun(int ind,int buy,int cap,int[] prices,int[][][] dp){
        if (cap==0)return 0;
        if (ind==prices.length)return 0;

        if (dp[ind][buy][cap]!=-1)return dp[ind][buy][cap];
        if (buy==1){
            return dp[ind][buy][cap]= Math.max(-prices[ind]+fun(ind+1,0,cap, prices,dp),fun(ind+1,1,cap,prices,dp));
        }
        else return dp[ind][buy][cap]= Math.max(prices[ind]+fun(ind+1,1,cap-1,prices,dp),fun(ind+1,0,cap,prices,dp));
    }

    public int maxProfit(int[] prices) {

        int n=prices.length;
        int[][][] dp=new int[n][2][3];
        for (int i=0;i<n;i++){
            for (int j=0;j<2;j++){
                for (int k=0;k<3;k++){
                    dp[i][j][k]=-1;
                }
            }
        }

        return fun(0,1,2,prices,dp);
    }
}
