package sliding_window_and_two_pointer;

public class Binary_Subarrays_With_Sum {
    public int numSubarraysWithSum(int[] nums, int goal) {
       return hepler(nums, goal)-hepler(nums,goal-1);
    }

    public int hepler(int[] nums, int goal){
        if(goal<0) return 0;
        int l=0;
        int Sum=0;
        int count=0;
        for(int r=0;r<nums.length;r++){
            Sum+=nums[r];
            while(Sum>goal){
                Sum-=nums[l];
                l++;}
            count+=r-l+1;
        }
        return count;
    }
}
