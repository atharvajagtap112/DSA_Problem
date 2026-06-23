package Leetcode_DailyChanllenge;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Meeting_Rooms_III {
    public static int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));
        int[] room=new int[n];
        int[] cnt=new int[n];
        int m=meetings.length;




        for (int i=0;i<m;i++){
            boolean isTrue=true;
            int minIdx=-1;
            int min=Integer.MAX_VALUE;
            for (int j=0;j<n;j++){
                if (room[j]<=meetings[i][0]){
                    isTrue=false;
                    if(room[j]==0) room[j]=meetings[i][1];
                    else room[j]=room[j]+meetings[i][1]-meetings[i][0];
                    cnt[j]++;

                }
                else {
                    if(min>room[j]){
                        min=room[j];
                        minIdx=j;
                    }
                }
            }
            if (isTrue){
                room[minIdx]=room[minIdx]+meetings[i][1]-meetings[i][0];
                cnt[minIdx]++;
            }

        }

        int max=Integer.MIN_VALUE;
        int idx=-1;
        for (int i=0;i<n;i++){
            if (max<cnt[i]){
                max=cnt[i];
                idx=i;
            }

        }
        return idx;
    }

    public static void main(String[] args) {
        System.out.println(mostBooked(3,new int[][]{ {1,27},{29,49},{47,49},{41,43},{15,36},{11,15} }));
    }
}
