package DP.Easy;

public class House_Robber {
    public int fun(int[] nums) {
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
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        int []temp =new int[n-1];
        int []temp2=new int[n-1];
        for(int i=0;i<n;i++){
            if(i<n-1){
                temp[i]=nums[i];
            }
            if(i>0){
                temp2[i-1]=nums[i];
            }
        }

        return Math.max(fun(temp),fun(temp2));
    }
}
