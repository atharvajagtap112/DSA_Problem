package DP.Easy.Dp_On_Stocks.Best_Time_to_Buy_and_Sell_Stock_3;

public class spaceOptimisation {

    public int maxProfit(int[] prices) {

        int n=prices.length;
        int[][] prev=new int[2][3];


        for (int ind=n-1;ind>=0;ind--){
            int[][] cur=new int[2][3];
            for (int buy=1;buy>=0;buy--){

                for (int cap=1;cap<=2;cap++){
                    if (buy==1){
                       cur[buy][cap]= Math.max(-prices[ind]+prev[0][cap],prev[1][cap]);
                    }
                    else  cur[buy][cap]= Math.max(prices[ind]+prev[1][cap-1],prev[0][cap]);
                }
            }
            prev=cur;
        }

        return  prev[1][2];
    }

}
