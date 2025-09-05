package DP.Subsequence;

import java.util.Arrays;

public class Partition_Array_Into_Two_Arrays_to_Minimize_Sum_Difference {
    public int minimumDifference(int[] nums) {

        int k=0;
        for (int i=0;i<nums.length;i++){
            k+=nums[i];
        }

        int n=nums.length;
        boolean [][]dp=new boolean[n+1][k+1];
        for (int i=0;i<n+1;i++){
            Arrays.fill(dp[i],false);
        }

        for (int i=0;i<nums.length;i++){
            dp[i][0]=true;
        }

        if(nums[0]<=k)
            dp[0][nums[0]]=true;

        for (int ind=1;ind<n;ind++){
            for (int target=1;target<=k;target++){

                boolean notTake=dp[ind-1][target];
                boolean take=false;
                if (nums[ind]<=target){
                    take=dp[ind-1][target-nums[ind]];
                }

                dp[ind][target]=notTake||take;
            }
        }


        int min= (int) 1e9;
        for (int i=0;i<=k;i++){
            if (dp[n-1][i])
             min=Math.min(min,i);
        }
        return min;
    }
}
