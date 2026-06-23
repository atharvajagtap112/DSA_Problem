package Leetcode_DailyChanllenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Maximum_Total_Damage_With_Spell_Casting {
    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);
        Map<Integer,Integer> map=new HashMap<>();
        for(int p:power){
            map.put(p,map.getOrDefault(p,0)+1); 
        }
        int ans=0;
        int n=power.length;
       int[] arr=new int[map.size()];
       int ind=1;
        for (int i=0;i<n;i++){
            if (i==0) arr[i]=power[0];
            else if(power[i-1]==power[i]) continue;
            arr[ind]=power[i];
            ind++;
        }
       for(int i=0;i<arr.length;i++){
           int temp=0;
           for(int j=i;j<arr.length;j=j+3){
               temp=temp+(arr[j]*map.get(arr[j]));
           }
           ans=Math.max(ans,temp);
       }
       return ans;
    }
}
