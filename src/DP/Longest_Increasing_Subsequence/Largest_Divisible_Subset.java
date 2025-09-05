package DP.Longest_Increasing_Subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Largest_Divisible_Subset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);

        int[] dp=new int[n];
        Arrays.fill(dp,1);

        int []hash=new int[n];

        int max=0;
        int lastIndex=0;

        for (int ind=0;ind<n;ind++){
            hash[ind]=ind;
            for (int j=0;j<ind;j++){
                if (nums[ind]%nums[j]==0&&dp[ind]<dp[j]+1){
                    dp[ind]=dp[j]+1;
                    hash[ind]=j;
                }
            }
            if (max<dp[ind]){
                max=dp[ind];
                lastIndex=ind;
            }

        }




        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(nums[lastIndex]);

        while (lastIndex!=hash[lastIndex]){

            lastIndex=hash[lastIndex];
            ans.add(nums[lastIndex]);
        }
        return ans;

    }
}
