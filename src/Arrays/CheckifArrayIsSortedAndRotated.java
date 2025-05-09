package Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CheckifArrayIsSortedAndRotated {
    public boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;


        for(int i = 0; i < n-1; i++ ){
            if(nums[i] > nums[i+1]){
                count++;
            }
        }

        if(nums[0] < nums[n-1]){
            count++;
        }

        return count <=1;
    }


    public static void main(String[] args) {
        CheckifArrayIsSortedAndRotated a=new CheckifArrayIsSortedAndRotated();

        int []arr={2,1,3,4};
        System.out.println(a.check(arr));

    }
}
