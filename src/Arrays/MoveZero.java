package Arrays;

import java.util.Arrays;

public class MoveZero {
    public static void moveZeroes(int[] nums) {
         int i=-1;
         for (int j=0;j<nums.length;j++){
             if (nums[j]==0){
                 i=j;
             }
         }
        for (int j=i+1;j<nums.length;j++){
            if (nums[j]!=0){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int []arr={4,2};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
