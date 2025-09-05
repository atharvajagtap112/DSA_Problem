package DP.Dp_On_Stocks;

public class Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        int min=prices[0];
        int profit=0;

        for(int i=1;i<prices.length;i++){
            int coast=prices[i]-min;
            profit=Math.max(coast,profit);
            min=Math.min(min,prices[i]);
        }
        return profit;
    }
}
