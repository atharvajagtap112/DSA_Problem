package DP.Subsequence.Coin_Change;


public class spaceOptimiation {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[] prev=new int[amount+1];


        //base case
        for (int target=0;target<=amount;target++){
            if (target%coins[0]==0)  prev[target]= target/coins[0];
            else prev[target]= (int)1e9;
        }

        for (int ind=1;ind<n;ind++){
            int[] cur=new int[amount+1];
            for (int target=0;target<=amount;target++){
                int notTake=0+prev[target];
                int take=(int) 1e9;
                if (coins[ind]<=target){
                    take=1+cur[target-coins[ind]];
                }
                cur[target]= Math.min(notTake,take);
            }
            prev=cur;
        }

        if (prev[amount]>=1e9)return -1;
        return prev[amount];
    }
}
