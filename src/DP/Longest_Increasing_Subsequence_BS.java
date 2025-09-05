package DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Longest_Increasing_Subsequence_BS {
    public int lengthOfLIS(int[] nums) {
        List<Integer> temp=new ArrayList<>();
           temp.add(nums[0]);
        for (int i=1;i<nums.length;i++){
          if (temp.get(temp.size()-1)<nums[i]){
              temp.add(nums[i]);
          }
          else {
              int ind=lower_bound(temp,nums[i]);
              temp.set(ind,nums[i]);
          }
     }
        return temp.size();
    }

    private int lower_bound(List<Integer> temp, int num) {
        int start=0;
        int end=temp.size()-1;

        while (start<=end){
            int mid=start+(end-start)/2;
            if (temp.get(mid)>=num){
                end=mid-1;
            }
            else  start=mid+1;;
        }

        return start;
    }
}
