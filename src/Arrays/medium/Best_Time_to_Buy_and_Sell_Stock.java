package Arrays.medium;

public class Best_Time_to_Buy_and_Sell_Stock {

    public static int maxProfit(int[] prices) {
    int maxProfit=0;
    int buy=prices[0];
    int cost=0;
    for (int i=1;i<prices.length;i++){
        cost=prices[i]-buy;
        maxProfit=Math.max(maxProfit,cost);
        if (cost<0){
            buy=Math.min(buy,prices[i]);
        }
    }
    return maxProfit;
    }


    public static void main(String[] args) {
        int[] arr={3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(arr));
    }
}
