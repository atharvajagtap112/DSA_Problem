package DP.Easy.Subsequence.Knapsack_with_Duplicate_Items;

public class recurr {
    static int fun(int ind,int W,int[] val,int[] wt){
        if (ind == 0) {
                 return (W/wt[ind])*val[ind];

        }

        int notTake=0+fun(ind-1,W,val,wt);
        int take=Integer.MIN_VALUE;
        if (wt[ind]<=W){
            take=val[ind]+fun(ind,W-wt[ind],val,wt);
        }
        return Math.max(notTake,take);
    }

    static int knapSack(int val[], int wt[], int capacity) {

      int n= wt.length;
      return fun(n-1,capacity,val,wt);
    }
}
