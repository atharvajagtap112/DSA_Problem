package DP.Pattern_Dp.Burst_Balloons;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class recurr {

    public int fun(int i,int j,ArrayList<Integer> list){
     if (i>j) return 0;

     int max=Integer.MIN_VALUE;
     for (int ind=i;ind<=j;ind++){
         int cost=list.get(i-1)*list.get(ind)*list.get(j+1)+fun(i,ind-1,list)+fun(ind+1,j,list);
        max=Math.max(max,cost);
     }
     return max;
    }
    public int maxCoins(int[] nums) {
        ArrayList<Integer> list=  new ArrayList<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
           list.add(0,1);

           list.add(list.size(),1);
           int n=list.size();
         return fun(1,n-2,list);
    }
}
