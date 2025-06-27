package DP.Easy.Dp_On_Stocks.Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee;

public class spaceOptimiation {
    public int maxProfit1(int[] prices, int fee) {
        int n=prices.length;
        int []after=new int[2];


        for(int i=n-1;i>=0;i--){
            int []cur=new int[2];
            for (int buy=0;buy<=1;buy++){

                if (buy==1){
                    cur[buy]= Math.max(-prices[i]+after[0],after[1]);
                }
                else cur[buy]= Math.max(prices[i]+after[1]-fee,after[0]);

            }
            after=cur;
        }

        return after[1];
    }



    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int aheadBuy=0;int aheadNotBut=0;


        for(int i=n-1;i>=0;i--){
            int curBuy=0;int curNotBuy=0;



            curNotBuy= Math.max(-prices[i]+aheadBuy,aheadNotBut);

            curBuy= Math.max(prices[i]+aheadNotBut-fee,aheadBuy);


            aheadBuy=curBuy;
            aheadNotBut=curNotBuy;
        }

        return aheadNotBut;
    }
}
