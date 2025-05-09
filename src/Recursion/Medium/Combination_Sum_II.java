package Recursion.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_II {
    public static   List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        combinations2(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }

    private static void combinations2(int index, int[] candidates, int target, List<List<Integer>> ans, ArrayList<Integer> list) {

            if (target==0){
                ans.add(new ArrayList<>(list));
                return;
            }

        for (int i=index;i<candidates.length;i++){
            if (i>index&&candidates[index]==candidates[index-1]) continue;
            if (target<candidates[i]) break;
            list.add(candidates[i]);
          combinations2(index+1,candidates,target-candidates[index],ans,list);
          list.remove(list.size()-i);
        }
    }

    public static void main(String[] args) {

      combinationSum2(new int[]{1,4,5,3,4},8);
    }
}
