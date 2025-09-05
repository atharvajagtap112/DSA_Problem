package DP.Subsequence;

import java.util.Arrays;

public class Partitions_With_Given_Difference {

    static int MOD = 1000000007;
    static int fun1(int ind,int[] arr,int sum,int [][] dp){


        if (ind==0){
            if (arr[0]==0&&sum==0) return 2;
            if (sum==0||arr[0]==sum) return 1;

            return 0;
        }
        if (dp[ind][sum]!=-1)return dp[ind][sum];

        int notTake=fun1(ind-1,arr,sum,dp);
        int take=0;
        if (arr[ind]<=sum){
            take=fun1(ind-1,arr,sum-arr[ind],dp);
        }


        return dp[ind][sum] =(notTake+take)%MOD;
    }

    public static int countPartitions1(int n, int d, int[] arr) {
     int totalSum=0;
        for (int i=0;i<arr.length;i++){
            totalSum+=arr[i];
        }

       if (totalSum-d<0)return 0;
       if ((totalSum-d)%2==1)return 0;

       int s2=(totalSum-d)/2;
       int [][]dp=new int[n+1][s2+1];
       for (int i=0;i<n+1;i++){
            Arrays.fill(dp[i],-1);
        }



       return fun1(n-1,arr,s2,dp);
    }

    public static int countPartitions(int n, int d, int[] arr) {
        int totalSum=0;
        for (int i=0;i<arr.length;i++){
            totalSum+=arr[i];
        }

        if (totalSum-d<0)return 0;
        if ((totalSum-d)%2==1)return 0;

        int s2=(totalSum-d)/2;
        int [][]dp=new int[n+1][s2+1];
        for (int i=0;i<n+1;i++){
            Arrays.fill(dp[i],-1);
        }




        if (arr[0]==0&&s2==0) dp[0][0]=2;
        else dp[0][0]=1;


        if(arr[0]!=0&& arr[0]<=s2){
            dp[0][arr[0]]=1;
        }


        for(int ind = 1; ind<n; ind++){
            for(int target= 0; target<=s2; target++){

                int notTaken = dp[ind-1][target];

                int taken = 0;
                if(arr[ind]<=target)
                    taken = dp[ind-1][target-arr[ind]];

                dp[ind][target]= (notTaken + taken)%MOD;
            }
        }
        return dp[n-1][s2];


    }

}
