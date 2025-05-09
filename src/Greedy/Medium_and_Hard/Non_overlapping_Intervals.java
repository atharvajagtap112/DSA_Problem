package Greedy.Medium_and_Hard;

import java.util.Arrays;

public class Non_overlapping_Intervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[1],b[1]));
        int n=intervals.length;
        int count=1;
        int lastend=intervals[0][1];
        for (int i=1;i<n;i++){
            if(intervals[i][1]>=lastend){
                count++;
                lastend=intervals[i][1];
            }
        }
        return n-count;
    }
}
