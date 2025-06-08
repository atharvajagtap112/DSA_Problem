package DP.Easy;

import java.util.Arrays;

public class Rob {
    int fun(int i,int[] nums,int[] dp){
        if(i==0) return nums[0];

        int left=Integer.MIN_VALUE;
        int right=nums[i];
        if(dp[i]>=0) return dp[i];

        left=fun(i-1,nums,dp);
        if(i-2>=0){
            right+=fun(i-2,nums,dp);}

        return dp[i]= Math.max(left,right);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        //return fun(nums.length-1,nums,dp);

        dp[0]=nums[0];

        for (int i=1;i<n;i++){
            int left=Integer.MIN_VALUE;
            int right=nums[i];


            left=dp[i-1];
            if(i-2>=0)
                right+=dp[i-2];

            dp[i]= Math.max(left,right);
        }
        return dp[n-1];
    }
    public int rob1(int[] nums) {
        int n=nums.length;
        int prev=nums[0];
        int prev2=0;

        for (int i=1;i<n;i++){
            int left=Integer.MIN_VALUE;
            int right=nums[i];
            left=prev;
            if(i-2>=0)
                right+=prev2;
            prev2=prev;
            prev= Math.max(left,right);


        }
        return prev;
    }
}
