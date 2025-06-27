package DP.Easy.Dp_On_Stocks.Best_Time_to_Buy_and_Sell_Stock_4;

public class spaceOptimiation {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int cap=2*k;
        int[] after=new int[cap+1];



        for (int ind=n-1;ind>=0;ind--){
            int[] cur=new int[cap+1];
            for (int buy=cap-1;buy>=0;buy--){
                if (buy%2==0){
                    cur[buy] = Math.max(-prices[ind]+after[buy+1],after[buy]);
                }
                else  cur[buy]= Math.max(prices[ind]+after[buy+1],after[buy]);
            }
            after=cur;
        }

        return after[0];
    }
}
