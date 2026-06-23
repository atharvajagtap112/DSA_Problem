package Leetcode_DailyChanllenge;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

public class Maximum_Number_of_Distinct_Elements_After_Operations {

    public int maxDistinctElements(int[] nums, int k) {

     int n=nums.length;
     Arrays.sort(nums);
     int cnt=1;
     nums[0]=nums[0]-k;
     for (int i=1;i<n;i++){

         int val= Math.max(nums[0]+1,nums[i]-k );
         if (val<=nums[i]+k){
             nums[i]=val;
             cnt++;
         }
         else nums[i]=nums[i-1];
     }return cnt;
    }
}
