package Recursion.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
       List<List<Integer>> ans=new ArrayList<>();
           Arrays.sort(nums);
        subsetHelper(0,nums,ans,new ArrayList<>());
     return  ans;

    }
   public void subsetHelper(int index,int [] nums,List<List<Integer>> ans,List<Integer> temp){
        if (index== nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i=index;i<nums.length;i++){
            if ( i>index &&nums[i]==nums[i-1]) continue;
            temp.add(nums[i]);
            subsetHelper(index+1,nums,ans,temp);
            temp.remove(temp.size()-1);

        }
    }
}
