package Arrays.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left,right};
            } else if (sum < target) left++;
            else right--;
        }
        return new int[] {-1,-1};
    }

    public static void main(String[] args) {
        int[] arr={3,2,4};
        System.out.println(Arrays.toString(twoSum(arr,6)));
    }
}



