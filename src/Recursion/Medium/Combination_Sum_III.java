package Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum_III {
    public static List<List<Integer>> combinationSum3(int k, int n) {
      List<List<Integer>> ans=new ArrayList<>();
       combinationSum3Helper(1,new ArrayList<>(),ans,k,n);
      return ans;
    }
    public static void combinationSum3Helper(int n,List<Integer> temp,List<List<Integer> >ans,int k,int target){
        if (k==0){
            if (target==0){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }


        for (int i=n;i<=9;i++){
            if (i>target-i&&target-i!=0) continue;
            if(i>target) break;
            temp.add(i);
            combinationSum3Helper(i+1,temp,ans,k-1,target-i);
            temp.remove(temp.size()-1);
        }

    }

    public static void main(String[] args) {
        int []att={1,2,3};
        combinationSum3(3,7);
    }
}
