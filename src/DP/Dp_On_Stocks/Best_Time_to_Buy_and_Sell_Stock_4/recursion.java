package DP.Dp_On_Stocks.Best_Time_to_Buy_and_Sell_Stock_4;

public class recursion {

    int  fun(int ind,int buy,int k ,int[]prices){
        if ( buy%2==0 && buy/2==k) return 0;

        if (ind==prices.length)return 0;



        if (buy%2==0){
            return Math.max(-prices[ind]+fun(ind+1,buy+1,k, prices),fun(ind+1,buy,k,prices));
        }
        else return  Math.max(prices[ind]+fun(ind+1,buy+1,k,prices),fun(ind+1,buy,k,prices));
    }
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int cap=2*k;


        return fun(0,0,k,prices);
    }
}
