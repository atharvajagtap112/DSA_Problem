package Leetcode_DailyChanllenge;

public class Trionic_Array_II {
    public long fun(int i,int[] nums,int trend){
        int n= nums.length;



         long skip=Long.MIN_VALUE;
         long take=Long.MIN_VALUE;
        if(trend==0){
             skip=fun(i+1,nums,0);
        }
        if (trend==3) take=nums[i];

        if (i<n-1){

            long curr=nums[i];
            long next=nums[i+1];
            if (trend==0&&curr<next) take=curr+fun(i+1,nums,1);
           else if (trend==1){
                if (curr<next){
                    take=curr+fun(i+1,nums,1);
                }
                else {
                    take=curr+fun(i+1,nums,2);
                }
            }

            else if (trend==3&&curr<next) take=curr+fun(i+1,nums,3);
        }


        return Math.max(skip,take);
    }

    public long maxSumTrionic(int[] nums) {
        return fun(0,nums,0);
    }
}
