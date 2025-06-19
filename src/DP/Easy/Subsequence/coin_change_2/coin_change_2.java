package DP.Easy.Subsequence.coin_change_2;

public class coin_change_2 {
    public int fun(int ind,int target,int[] coins){
        if(ind==0){
            if(target%coins[0]==0) return 1;
            return 0;
        }

        int notTake=0+fun(ind-1,target,coins);
        int take=0;
        if(target>=coins[ind]){
            take=fun(ind,target-coins[ind],coins);
        }
        return take+notTake;
    }

    public int change(int amount, int[] coins) {
        int n=coins.length;
        return fun(n-1,amount,coins);
    }
}
