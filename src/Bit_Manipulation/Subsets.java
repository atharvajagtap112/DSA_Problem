package Bit_Manipulation;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> ans=new ArrayList<>();
       for (int i=0;i<Math.pow(2, nums.length);i++){
           List<Integer> list=new ArrayList<>();
           for (int j=0;j<nums.length;j++){
               if ((i&(1<<j))==1){
                   list.add(nums[j] );

               }

           }
           ans.add(list);

       }
       return ans;
    }
}
