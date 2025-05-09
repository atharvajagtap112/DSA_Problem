package sliding_window_and_two_pointer;

public class Count_Number_of_Nice_Subarrays {
    public int numberOfSubarrays(int[] nums, int k) {
    return niceSubarrays(nums, k)-niceSubarrays(nums,k-1);
    }

    public int niceSubarrays(int [] nums ,int k){
        if (k<0) return 0;
        int l=0; int count =0; int sum=0;
        for (int r=0;r<nums.length;r++){
            sum+=nums[r]%2;

            while (sum> k){
                sum-=nums[l]%2;
                l++;
            }
            count+=r-l+1;
        }
        return count;
    }
}
