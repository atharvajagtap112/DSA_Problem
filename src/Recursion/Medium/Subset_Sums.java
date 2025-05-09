package Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class Subset_Sums {
    public static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> ans=new ArrayList<>();
         subsetSumsHelper(0,0,arr,n,ans);
        return ans;
    }

    private static void subsetCombiSum(ArrayList<Integer> arr, int n, ArrayList<Integer> ans,int sum  ) {
         if (arr.isEmpty()){
            ans.add(sum);
            return;
         }
         int no= arr.get(0);
         arr.remove(0);
         subsetCombiSum(arr,n,ans,sum+no);

         subsetCombiSum(arr,n,ans,sum);
         arr.add(no);
         return;
    }
    static void subsetSumsHelper(int ind, int sum, ArrayList < Integer > arr, int N, ArrayList < Integer > sumSubset) {
        if (ind == N) {
            sumSubset.add(sum);
            return;
        }


        subsetSumsHelper(ind + 1, sum + arr.get(ind), arr, N, sumSubset);


        subsetSumsHelper(ind + 1, sum, arr, N, sumSubset);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(2);
        list.add(3);
        subsetSums(list, list.size());

    }
}
