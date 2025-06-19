package DP.Easy.Subsequence.Coin_Change;

public class recurr {
    public int fun(int ind,int target,int[] coins){

        if (ind==0){
            if (target%coins[ind]==0)return target/coins[ind];
            return (int)1e9;
        }

        int notTake=0+fun(ind-1,target,coins);
        int take=(int) 1e9;
        if (coins[ind]<=target){
            take=1+fun(ind,target-coins[ind],coins);
        }
        return Math.min(notTake,take);
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int ans=fun(n-1,amount,coins);
        if (ans>=1e9)return -1;
        return ans;
    }
}
