package DP.Subsequence.coin_change_2;

public class spaceOptimiation {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int []prev= new int[amount+1];

        for (int target=0;target<=amount;target++){
            if(target%coins[0]==0) prev[target]= 1;
            else prev[target]= 0;
        }

        for (int ind=1;ind<n;ind++){
            int[] cur=new int[amount+1];
            for (int target=0;target<=amount;target++){

                int notTake=0+prev[target];
                int take=0;
                if(target>=coins[ind]){
                    take=cur[target-coins[ind]];
                }
                cur[target]= take+notTake;

            }
            prev=cur;
        }
        return prev[amount];
    }
}
