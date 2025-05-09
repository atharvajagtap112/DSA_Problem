package Recursion.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        backtracking(result,new ArrayList<>(),nums,0);
        return result;

    }

    private static void backtracking(List<List<Integer>> result, List<Integer> tempset, int[] nums, int start) {
        result.add(new ArrayList<>(tempset));
        for (int i=start;i< nums.length;i++){
            tempset.add(nums[i]);
            backtracking(result,tempset,nums,i+1);
            tempset.remove(tempset.size()-1);
        }
    }

    public static void main(String[] args) {
        int[]nums={1,2,3};
      List<List<Integer>>ans=subsets(nums);
      for (List<Integer> a:ans){
          System.out.println(a);
      }

    }
}
