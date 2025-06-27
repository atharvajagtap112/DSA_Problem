package DP.Easy.Dp_On_Stocks.Best_Time_to_Buy_and_Sell_Stock_3;

public class recurrsion {

    public int fun(int ind,int buy,int cap,int[] prices){
        if (cap==0)return 0;
        if (ind==prices.length)return 0;


        if (buy==1){
            return Math.max(-prices[ind]+fun(ind+1,0,cap, prices),fun(ind+1,1,cap,prices));
        }
        else return Math.max(prices[ind]+fun(ind+1,1,cap-1,prices),fun(ind+1,0,cap,prices));
    }

    public int maxProfit(int[] prices) {
     return fun(0,1,2,prices);
    }
}
