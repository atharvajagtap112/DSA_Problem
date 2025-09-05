package DP.Pattern_Dp.Minimum_Cost_to_Cut_a_Stick;

import java.util.ArrayList;
import java.util.Arrays;

public class recurr {
    public int fun(int i,int j,ArrayList<Integer> list){
      if(i>j)return 0;

      int min=(int) 1e9;
      for (int ind=i;ind<=j;ind++){
          int step=list.get(j+1)-list.get(i-1)+fun(i,ind-1,list)+fun(ind+1,j,list);
          min=Math.min(min,step);
      }

      return min;
    }

    public int minCost(int n, int[] cuts) {
        int[][] dp=new int[n][n];

        Arrays.sort(cuts);
        ArrayList<Integer> list=new ArrayList<>();
        list.add(0);
        Arrays.stream(cuts).forEach(list::add);
        list.add(n);
        return fun(1,list.size()-2,list);
    }
}
