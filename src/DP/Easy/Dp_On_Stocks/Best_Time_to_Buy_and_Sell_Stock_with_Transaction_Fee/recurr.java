package DP.Easy.Dp_On_Stocks.Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee;

public class recurr {
    public int fun(int i,int buy,int[] prices,int fee){
        if (i==prices.length)return 0;


        if (buy==1){
            return Math.max(-prices[i]+fun(i+1,0,prices,fee),fun(i+1,1,prices,fee));
        }
        else return Math.max(prices[i]+fun(i+1,1,prices,fee)-fee,fun(i+1,0,prices,fee));
    }
    public int maxProfit(int[] prices, int fee) {
        return fun(0,1,prices, fee);
    }
}
