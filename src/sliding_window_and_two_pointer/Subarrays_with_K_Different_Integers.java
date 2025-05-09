package sliding_window_and_two_pointer;

import java.util.HashMap;
import java.util.Map;

public class Subarrays_with_K_Different_Integers {

    public int subarraysWithKDistinct(int[] nums, int k) {
   return NumOfSubarray(nums, k) -NumOfSubarray(nums, k-1);
    }

     public int NumOfSubarray(int [] nums , int k){
         int l=0; int count=0;
         Map<Integer,Integer> map=new HashMap<>();
         for (int r=0;r<nums.length;r++){
             map.put(nums[r], map.getOrDefault(nums[r],0)+1);
             while (map.size()>k){
                 map.put(nums[l],map.get(nums[l])-1);
                 if(map.get(nums[l])==0 ) map.remove(nums[l]);
                 l++;
             }

             if(map.size()<=k) {
                 count+=r-l+1;
             }
         }
         return count;
     }
}
