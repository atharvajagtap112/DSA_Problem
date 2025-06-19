package DP.Easy.Subsequence;

import java.util.Arrays;

public class Subset_Sum_Equal_To_K {
   static boolean fun1(int ind,int[] arr,int target){
       if (target==0) return true;

       if (ind==0) return arr[ind]==target;

       boolean notTake=fun1(ind-1,arr,target);
       boolean take=false;
       if (arr[ind]<=target){
           take=fun1(ind-1,arr,target-arr[ind]);
       }


       return notTake||take;
    }
    public static boolean subsetSumToK1(int n, int k, int arr[]){
        return fun1(n-1,arr,k);
    }

    static boolean fun2(int ind,int[] arr,int target,int [][] dp){
        if (target==0) return true;

        if (ind==0) return arr[ind]==target;

        if (dp[ind][target]!=-1) return dp[ind][target]==1;
        boolean notTake=fun2(ind-1,arr,target,dp);
        boolean take=false;
        if (arr[ind]<=target){
            take=fun2(ind-1,arr,target-arr[ind],dp);
        }

        dp[ind][target]=(notTake||take)?1:0;
        return notTake||take;
    }
    public static boolean subsetSumToK2(int n, int k, int arr[]){
       int [][]dp=new int[n+1][k+1];
       for (int i=0;i<n+1;i++){
           Arrays.fill(dp[i],-1);
       }
        return fun2(n-1,arr,k,dp);
    }

    public static boolean subsetSumToK4(int n, int k, int arr[]){
        boolean [][]dp=new boolean[n+1][k+1];
        for (int i=0;i<n+1;i++){
            Arrays.fill(dp[i],false);
        }

        for (int i=0;i<arr.length;i++){
            dp[i][0]=true;
        }

        if(arr[0]<=k)
         dp[0][arr[0]]=true;

        for (int ind=1;ind<n;ind++){
            for (int target=1;target<=k;target++){

                boolean notTake=dp[ind-1][target];
                boolean take=false;
                if (arr[ind]<=target){
                    take=dp[ind-1][target-arr[ind]];
                }

                dp[ind][target]=notTake||take;
            }
        }


        for (int i=0;i<n+1;i++){
            for (int j=0;j<k+1;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println(" ");
        }

        return dp[n-1][k];
    }


    public static boolean subsetSumToK(int n, int k, int arr[]){
        boolean [] prev=new boolean[k+1];




       prev[0]=true;

           if (arr[0]<=k)
             prev[arr[0]]=true;

        for (int ind=1;ind<n;ind++){
            boolean [] curr=new boolean[k+1];

            curr[0]=true;
            for (int target=1;target<=k;target++){

                boolean notTake=prev[target];
                boolean take=false;
                if (arr[ind]<=target){
                    take=prev[target-arr[ind]];
                }

                curr[target]=notTake||take;
            }
            prev=curr;
        }
        return prev[k];
    }

    public static void main(String[] args) {
        subsetSumToK4(3,12,new int[]{3,2,7});
    }
}
