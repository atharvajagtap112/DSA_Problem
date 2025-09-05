package DP.Dp_On_Stocks.Best_Time_to_Buy_and_Sell_Stock_with_Cooldown;

public class recurr {
    public int fun(int i,int buy,int[] prices){
        if (i>=prices.length)return 0;


        if (buy==1){
            return Math.max(-prices[i]+fun(i+1,0,prices),fun(i+1,1,prices));
        }
        else return Math.max(prices[i]+fun(i+2,1,prices),fun(i+1,0,prices));
    }
    public int maxProfit(int[] prices) {
        return fun(0,1,prices);
    }
}
