package Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
         combinaitons(0,candidates,target,ans,new ArrayList<>());
         return ans;

    }
     public static void combinaitons(int index,int []arr,int target,List<List<Integer>> ans,List<Integer> ds){
        if (index==arr.length){
            if (target==0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if (arr[index]<=target){
            ds.add(arr[index]);
            combinaitons(index,arr,target-arr[index],ans,ds);
            ds.remove(arr[index]);
        }
        combinaitons(index+1,arr,target,ans,ds);
     }

}
