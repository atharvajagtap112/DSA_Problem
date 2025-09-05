package DP.Longest_Increasing_Subsequence;

import java.util.*;

public class Number_of_Longest_Increasing_Subsequence {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;

        int[]dp=new int[n];
        int[] cnt=new int[n];

        int max=0;
        Arrays.fill(dp,1);
        Arrays.fill(cnt,1);

        for (int i=0;i<n;i++){

            for (int j=0;j<i;j++){


                if (nums[i]>nums[j]&& dp[i]<dp[j]+1){

                    dp[i]=dp[j]+1;
                    cnt[i]=cnt[j];}

                else  if (nums[i]>nums[j]&& dp[i]==dp[j]+1) cnt[i]+=cnt[j];
            }

            max= Math.max(max,dp[i]);
        }

        int nos=0;
        for(int i=0;i<n;i++){
            if(max==dp[i]) nos+=cnt[i];
        }
        return nos;
    }
}
