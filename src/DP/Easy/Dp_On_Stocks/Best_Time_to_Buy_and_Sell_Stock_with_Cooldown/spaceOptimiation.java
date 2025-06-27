package DP.Easy.Dp_On_Stocks.Best_Time_to_Buy_and_Sell_Stock_with_Cooldown;

public class spaceOptimiation {
    public int maxProfit(int[] prices) {
        int n=prices.length+2;
        int[] after=new int[2];
        int nextToAfter=0;
        for (int i=n-3;i>=0;i--){
            int[] cur=new int[2];
            for (int buy=0;buy<=1;buy++){


                if (buy==1){
                    cur[buy]= Math.max(-prices[i]+after[0],after[1]);
                }
                else  cur[buy]= Math.max(prices[i]+nextToAfter,after[0]);
            }

            nextToAfter=after[1];
            after=cur;
        }

        return after[1];

    }

}
