package Arrays;

import java.util.Arrays;

public class RotateArray {

        public void rotate(int[] nums, int k) {
           for (int j=0;j<k;j++){
            for (int i=nums.length-2;i>=0;i--) {
                int temp = nums[i + 1];
                nums[i + 1] = nums[i];
                nums[i] = temp;
            }
}

        }

    public static void main(String[] args) {
        int[]arr={1,2};
        RotateArray a=new RotateArray();
        a.rotate(arr,3);
        System.out.println(Arrays.toString(arr));
        
    }
        }
//            if(nums.length!=1){
//                reverse(nums,0,nums.length-1);
//                reverse(nums,0,k-1);
//                reverse(nums,k,nums.length-1);}
//
//        }
//        public void reverse(int[]nums,int start,int end){
//            while (start<end){
//                int temp=nums[start];
//                nums[start]=nums[end];
//                nums[end]=temp;
//                start++;
//                end--;
//            }
//        }


