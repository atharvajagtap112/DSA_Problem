package DP.Easy.Subsequence;

public class Partition_Equal_Subset_Sum {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }

        if(sum%2==1)return false;

        int k=sum/2;

        boolean [] prev=new boolean[k+1];




        prev[0]=true;

        if (nums[0]<=k)
            prev[nums[0]]=true;

        for (int ind=1;ind< nums.length;ind++){
            boolean [] curr=new boolean[k+1];

            curr[0]=true;
            for (int target=1;target<=k;target++){

                boolean notTake=prev[target];
                boolean take=false;
                if (nums[ind]<=target){
                    take=prev[target-nums[ind]];
                }

                curr[target]=notTake||take;
            }
            prev=curr;
        }
        return prev[k];
    }

}
