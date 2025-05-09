package Arrays.medium;

import java.util.Arrays;

public class SortColors {
    public void sortColors(int[] nums) {
        int low=0;
        int mid=0;
        int high= nums.length-1;

        while (mid<=high){
            if (nums[mid]==0){
                swap(low,mid,nums);
                low++;
                mid++;
            }
            else if (nums[mid]==1){
                mid++;
            }
            else {
                swap(high,mid,nums );
                high--;
            }
        }

    }
    private void swap(int first,int second,int[]nums){
        int temp=nums[first];
        nums[first]=nums[second];
        nums[second]=temp;
    }


    public static void main(String[] args) {
        int[] nums={2,0,2,1,1,0};
        //sortColors(nums);
        System.out.println(Arrays.toString(nums));

    }
}
