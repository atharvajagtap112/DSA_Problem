package Greedy.Medium_and_Hard;

import java.util.ArrayList;
import java.util.Arrays;

public class Merge_Intervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        ArrayList<int[]> list=new ArrayList<>();
        int n= intervals.length;
        int i=0;
        while (i<n){
            int start=intervals[i][0];
            int end=intervals[i][1];
            int j=i;
            while (i<n-1&&end>=intervals[i+1][0]&&start<=intervals[i+1][1]){
                start=Math.min(start,intervals[i+1][0]);
                end=Math.max(end,intervals[i+1][1]);
                i++;
            }
            list.add(new int []{start, end});
            i++;

        }
        int[][] ans=new int[list.size()][2];
        for (int j=0;j<list.size();j++ ){
            ans[j][0]=list.get(j)[0];
            ans[j][1]=list.get(j)[1];
        }
        return ans;
    }
}
