package Leetcode_DailyChanllenge;

import java.util.HashSet;
import java.util.Set;

public class Avoid_Flood_in_The_City {
    public int[] avoidFlood(int[] rains) {
     int n=rains.length;
     int[] ans=new int[n];
        Set<Integer> set=new HashSet<>();
        for (int i=0;i<n;i++){
            if (rains[i]==0){
                if (set.isEmpty()){
                    ans[i]=1;
                }
                else {
                    int j=i;
                    while(j<n&&rains[j]==0) j++;
                    boolean flag=true;
                    while (j<n&&rains[j]!=0){
                        if (set.contains(rains[j])){
                            ans[i]=rains[j];
                            set.remove(rains[j]);
                            flag=false;
                            break;
                        }
                        j++;
                    }
                    if (flag) {
                        int val=set.iterator().next();
                        ans[i]=val;
                        set.remove(val);
                    }
                }
            }

            else {
                if (set.contains(rains[i])) return new int[n];
                ans[i]=-1;
                set.add(rains[i]);
            }
        }
        return ans;
    }
}
