package Arrays.medium;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {

         int index=-1;
         int n=nums.length;
         for (int i=n-2;i>=0;i--){
             if (nums[i]<nums[i+1]){
                 index=i;
                 break;
             }
         }
         if (index==-1){
             reverse(nums,0,n-1);
             return;
         }
         for (int i=n-1;i>index;i--){
             if (nums[i]>nums[index]){
                 int temp=nums[i];
                 nums[i]=nums[index];
                 nums[index]=temp;
                 break;
             }
         }
         reverse(nums,index+1,n-1);

    }
    public static void reverse(int []arr,int start,int end){

        while (start<=end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[]arr={1,3,2};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

}
