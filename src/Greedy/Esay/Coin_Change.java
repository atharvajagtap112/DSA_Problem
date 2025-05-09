package Greedy.Esay;

import java.util.Arrays;

public class Coin_Change {
    public int coinChange(int[] coins, int amount) {
        int ans=0;
        int count=0;
        Arrays.sort(coins);
        for (int i=coins.length-1;i>=0 ;i--){

            while (ans+coins[i]<=amount){
                ans+=coins[i];
                count++;
            }
            if (ans==amount) {
                return count;
            }
        }
        return -1;
    }
}
