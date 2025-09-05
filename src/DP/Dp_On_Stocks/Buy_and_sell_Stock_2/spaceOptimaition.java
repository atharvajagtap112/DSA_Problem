package DP.Dp_On_Stocks.Buy_and_sell_Stock_2;

public class spaceOptimaition {
    public int maxProfit1(int[] prices) {
        int n=prices.length;
        int[]ahead =new int[2];

        for (int i=n-1;i>=0;i--){
            int []cur=new int[2];
            for (int buy=0;buy<=1;buy++){
                if (buy==1){
                    cur[buy] = Math.max( -prices[i]+ahead[0] , ahead[1] );
                }
                else  cur[buy]= Math.max(  prices[i]+ahead[1] , ahead[0] );
            }
            ahead=cur;
        }

        return ahead[1];
    }


    public int maxProfit(int[] prices) {
        int n=prices.length;
        int aheadBuy =0 ; int aheadNotBuy=0;

        for (int i=n-1;i>=0;i--){
            int curAheadBuy = 0; int curAheadNotBuy=0;


            curAheadBuy = Math.max( -prices[i]+aheadNotBuy , aheadBuy );
            curAheadNotBuy= Math.max(  prices[i]+aheadBuy , aheadNotBuy );

            aheadBuy=curAheadBuy;
            aheadNotBuy=curAheadNotBuy;
        }

        return aheadBuy;
    }
}
