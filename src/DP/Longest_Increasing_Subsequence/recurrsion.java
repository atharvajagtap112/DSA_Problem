package DP.Longest_Increasing_Subsequence;

public class recurrsion {

    public int fun(int ind,int prev,int[] nums){
        if (ind== nums.length) return 0;

        int notTake=fun(ind+1,prev,nums);
        int take=0;
        if (prev==-1||nums[ind]>nums[prev]){
            take=1+fun(ind+1,ind,nums);
        }

        return Math.max(take,notTake);
    }
    public int lengthOfLIS(int[] nums) {
        return fun(0,-1,nums);
    }
}
